package com.example.kronos.practicaadd2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Principal extends Activity {


    private GestionarJugador gj;
    private static final int JUGADOR=2;
    private static final int PARTIDOS=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        gj = new GestionarJugador(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal, menu);
        return super.onCreateOptionsMenu(menu);
    }






    @Override
    protected void onPause() {
        super.onPause();
        gj.close();
    }
    public void jugadorLista(View view){
        Intent i = new Intent(this,PJugador.class);
        startActivityForResult(i, JUGADOR);
    }
    public void partidoLista(View view){
        Intent i = new Intent(this,PPartidos.class);
        startActivityForResult(i, PARTIDOS);
    }

}
