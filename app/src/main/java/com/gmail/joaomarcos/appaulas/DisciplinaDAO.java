package com.gmail.joaomarcos.appaulas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    public static void inserir(Context context, Disciplina disciplina){
        ContentValues valores = new ContentValues();
        valores.put("nome", disciplina.getNome());
        valores.put("aula", disciplina.getAula());
        valores.put("turno", disciplina.getTurno());

        Banco conn = new Banco(context);
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();

        sqLiteDatabase.insert("disciplinas", null, valores);
    }

    public static void editar(Context context, Disciplina disciplina){
        ContentValues valores = new ContentValues();
        valores.put("nome", disciplina.getNome());
        valores.put("aula", disciplina.getAula());
        valores.put("turno", disciplina.getTurno());

        Banco conn = new Banco(context);
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();

        sqLiteDatabase.update("disciplinas", valores, "id = " + disciplina.getId(), null);
    }

    public static void excluir(Context context, int idDisciplina){

        Banco conn = new Banco(context);
        SQLiteDatabase sqLiteDatabase = conn.getWritableDatabase();

        sqLiteDatabase.delete("disciplinas", "id = " + idDisciplina, null);
    }

    public static List<Disciplina> getDisciplinas(Context context){
        List<Disciplina> lista = new ArrayList<>();

        Banco conn = new Banco(context);
        SQLiteDatabase sqLiteDatabase = conn.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM disciplinas ORDER BY nome", null);

        if( cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Disciplina disc = new Disciplina();
                disc.setId(cursor.getInt(0));
                disc.setNome(cursor.getString(1));
                disc.setAula(cursor.getString(2));
                disc.setTurno(cursor.getString(3));
                lista.add(disc);
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public static Disciplina getDisciplinaById(Context context, int idDiscplina){

        Banco conn = new Banco(context);
        SQLiteDatabase sqLiteDatabase = conn.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM disciplinas WHERE id = " + idDiscplina, null);

        if( cursor.getCount() > 0){
            cursor.moveToFirst();

            Disciplina disc = new Disciplina();
            disc.setId(cursor.getInt(0));
            disc.setNome(cursor.getString(1));
            disc.setAula(cursor.getString(2));
            disc.setTurno(cursor.getString(3));

            return disc;
        }else{
            return null;
        }
    }

}
