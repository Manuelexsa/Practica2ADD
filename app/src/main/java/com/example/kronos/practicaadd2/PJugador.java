package com.example.kronos.practicaadd2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class PJugador extends Activity {

    private EditText etNombre, etFecha, etValoracion, etTelefono;
    private GestionarJugador gj;
    private Adaptador1 ad1;

    private static final int CREAR=0;
    private static final int MODIFICAR=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_pjugador);
        gj = new GestionarJugador(this);
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
            case R.id.addj:
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
        gj.open();
        Cursor c = gj.getCursor(null, null, null);
        ad1 = new Adaptador1(this, c);
        final ListView lv =(ListView) findViewById(R.id.lvLista);
        lv.setAdapter(ad1);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) lv.getItemAtPosition(position);
                Jugador j = gj.getRow(cursor);
                gj.delete(j);
                //el changecursor se usa para actualizar los datos del cursor
                ad1.changeCursor(gj.getCursor(null, null, null));
                return false;
            }
        });
    }
    public void alta(View v){
        String nombre, fecha, telefono;
        nombre=etNombre.getText().toString();
        fecha=etFecha.getText().toString();
        telefono=etTelefono.getText().toString();
        Jugador j = new Jugador(nombre,telefono,fecha);
        Long id = gj.insert(j);
        Toast.makeText(this, "El jugador que se ha insertado tiene el id: " + id, Toast.LENGTH_LONG).show();
        Cursor c = gj.getCursor(null,null,null);
        ad1.changeCursor(c);
    }
    public void actualizarLista(){
        Cursor c = gj.getCursor(null,null,null);
        ad1.changeCursor(c);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String nombre;
            String telefono;
            String fnac;
            Jugador j;
            gj.open();
            switch (requestCode) {
                case CREAR:
                    nombre = data.getStringExtra("nombre");
                    telefono = data.getStringExtra("tlf");
                    fnac = data.getStringExtra("fnac");
                    j = new Jugador(nombre, telefono, fnac);
                    gj.insert(j);
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
