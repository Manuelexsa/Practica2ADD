package com.example.kronos.practicaadd2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kronos on 10/12/2014.
 */
public class Adaptador1 extends CursorAdapter {
    private TextView tvNombre, tvTelefono, tvFnac;
    private Cursor c;
    private LinearLayout lin;

    public Adaptador1(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater i = LayoutInflater.from(viewGroup.getContext());
        View v = i.inflate(R.layout.listadetalle, viewGroup, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        GestionarJugador gj = new GestionarJugador(context);
            Jugador j = gj.getRow(cursor);
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);
            tvFnac = (TextView) view.findViewById(R.id.tvFnac);
            tvNombre.setText(j.getNombre());
            tvFnac.setText(j.getFnac());
            tvTelefono.setText(j.getTelefono());


    }
}
