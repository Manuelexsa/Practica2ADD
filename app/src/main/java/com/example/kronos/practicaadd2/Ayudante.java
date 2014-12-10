package com.example.kronos.practicaadd2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kronos on 10/12/2014.
 */
public class Ayudante extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "futbol.sqlite";
    public static final int DATABASE_VERSION = 10;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*
        //creo tabla auxiliar para mantener los datos
        String sql = "CREATE TABLE auxJugador (id INTEGER, nombre TEXT, telefono TEXT,  fnac TEXT)";
        db.execSQL(sql);
        sql = "INSERT INTO auxJugador(id,nombre,telefono,fnac) SELECT * FROM Jugador";
        db.execSQL(sql);
        //borro tabla original
        sql = "drop table if exists " + Contrato.TablaJugador.TABLA;
        db.execSQL(sql);
        //creo tabla nueva
        onCreate(db);
        //meto datos en tablas nuevas
        sql = "INSERT INTO " + Contrato.TablaJugador.TABLA + " (" + Contrato.TablaJugador.NOMBRE + " , " +
                Contrato.TablaJugador.TELEFONO + " , " + Contrato.TablaJugador.FNAC + ") SELECT nombre, telefono, fnac FROM auxJugador";
        db.execSQL(sql);
        sql = "INSERT INTO " + Contrato.TablaPartido.TABLA + " (" + Contrato.TablaPartido.VALORACION + " , "
                + Contrato.TablaPartido.IDJUGADOR +
                " ) SELECT valoracion, " + Contrato.TablaJugador._ID + " FROM auxJugador j INNER JOIN " +
                Contrato.TablaJugador.TABLA + " ju WHERE j.nombre=ju." + Contrato.TablaJugador.NOMBRE +
                " AND j.telefono=ju." + Contrato.TablaJugador.TELEFONO +
                " AND j.fnac=ju." + Contrato.TablaJugador.FNAC;
        db.execSQL(sql);
        sql = "UPDATE " + Contrato.TablaPartido.TABLA + " SET " + Contrato.TablaPartido.CONTRINCANTE + "='Contrincante'";
        db.execSQL(sql);
        //borro tabla auxJugador
        sql = "drop table auxJugador";
        db.execSQL(sql);
*/

        String sql = "drop table Jugador";
        db.execSQL(sql);

        sql = "drop table Partido";
        db.execSQL(sql);

        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql = "create table " + Contrato.TablaJugador.TABLA +
                " (" + Contrato.TablaJugador._ID +
                " integer primary key autoincrement, " +
                Contrato.TablaJugador.NOMBRE + " text, " +
                Contrato.TablaJugador.TELEFONO + " text," +
                Contrato.TablaJugador.FNAC + " text)";
        Log.v("sql", sql);
        db.execSQL(sql);

        sql = "create table " + Contrato.TablaPartido.TABLA +
                " (" + Contrato.TablaJugador._ID +
                " integer primary key autoincrement, " +
                Contrato.TablaPartido.CONTRINCANTE + " text, " +
                Contrato.TablaPartido.IDJUGADOR + " long," +
                Contrato.TablaPartido.VALORACION + " int)";
        Log.v("sql", sql);
        db.execSQL(sql);

        /*
        String sql;

        sql = "create table "+Contrato.TablaJugador.TABLA+
                " ("+Contrato.TablaJugador._ID+
                " integer primary key autoincrement, "+
                Contrato.TablaJugador.NOMBRE+" text, "+
                Contrato.TablaJugador.TELEFONO+" text,"+
                Contrato.TablaJugador.VALORACION+" integer,"+
                Contrato.TablaJugador.FNAC+" text)";
        Log.v("sql", sql);
        db.execSQL(sql);*/
    }
}