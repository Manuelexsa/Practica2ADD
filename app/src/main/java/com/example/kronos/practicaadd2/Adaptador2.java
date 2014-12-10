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
public class Adaptador2 extends CursorAdapter {
    private TextView  tvValoracion,tvcontrincante,tvjugador;
    private Cursor c;
    private LinearLayout lin;

    public Adaptador2(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater i = LayoutInflater.from(viewGroup.getContext());
        View v = i.inflate(R.layout.listadetallepartido, viewGroup, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


            GestionarPartido gp = new GestionarPartido(context);
            Partido p = gp.getRow(cursor);
        tvjugador = (TextView) view.findViewById(R.id.tvJPartido);
        tvcontrincante = (TextView) view.findViewById(R.id.tvContrincante);
            tvValoracion = (TextView) view.findViewById(R.id.tvValorPartido);


    }
}
