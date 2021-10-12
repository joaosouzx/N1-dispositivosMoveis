package com.gmail.joaomarcos.appaulas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "AppLista";
    private static final int VERSAO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(     "CREATE TABLE IF NOT EXISTS disciplinas (" +
                                    " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT  ," +
                                    " NOME TEXT NOT NULL , " +
                                    " aula TEXT," +
                                    " turno TEXT);"
                                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
