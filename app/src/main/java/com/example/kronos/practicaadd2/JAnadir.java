package com.example.kronos.practicaadd2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class JAnadir extends Activity {
    private EditText etNombre, etFecha, etValoracion, etTelefono;
    long index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janadir);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etFecha = (EditText)findViewById(R.id.etFecha);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        Bundle b = getIntent().getExtras();
        if(b !=null ){
            Jugador j = (Jugador)b.getSerializable("jugador");
            index = j.getId();
            etNombre.setText(j.getNombre());
            etFecha.setText(j.getFnac());
            etTelefono.setText(j.getTelefono()+"");
        }


    }

    public void aceptar(View v){
        String Nombre, Fecha, Valoracion, Telefono;
        Nombre=etNombre.getText().toString();
        Fecha= etFecha.getText().toString();
        Telefono = etTelefono.getText().toString();

        Intent i = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("nombre",Nombre);
        bundle.putString("fnac",Fecha);
        bundle.putString("tlf", Telefono);
        i.putExtras(bundle);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
    public void cancelar(View v){
        Intent i = new Intent();
        setResult(Activity.RESULT_CANCELED, i);
        finish();
    }
}
