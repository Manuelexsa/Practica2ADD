package com.example.kronos.practicaadd2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class PPartidos extends Activity {

    private GestionarPartido gp;
    private Adaptador2 ad2;
    private static final int CREAR=0;
    private static final int MODIFICAR=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_ppartidos);
        gp = new GestionarPartido(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pjugador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addp:
                Intent i = new Intent(this,JAnadir.class);
                startActivityForResult(i, CREAR);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        gp.open();
        Cursor c = gp.getCursor(null, null, null);
        ad2 = new Adaptador2(this, c);
        final ListView lv = (ListView) findViewById(R.id.lvLista);
        lv.setAdapter(ad2);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) lv.getItemAtPosition(position);
                Partido p = gp.getRow(cursor);
                gp.delete(p);
                //el changecursor se usa para actualizar los datos del cursor
                ad2.changeCursor(gp.getCursor(null, null, null));
                return false;
            }
        });
    }
    public void actualizarLista(){
        Cursor c = gp.getCursor(null,null,null);
        ad2.changeCursor(c);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String nombre;
            String telefono;
            String fnac;
            Jugador j;
            gp.open();
            switch (requestCode) {
                case CREAR:
                    actualizarLista();
                    break;
            }
        } else {
            switch (requestCode) {
                case CREAR:
                    Toast.makeText(this, "El jugador que no se ha insertado", Toast.LENGTH_LONG).show();
                    break;
                case MODIFICAR:

                    Toast.makeText(this, "Modificacion del jugador correcta", Toast.LENGTH_LONG).show();
                    break;


            }
        }
    }
}