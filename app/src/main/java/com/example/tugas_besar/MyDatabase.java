package com.example.tugas_besar;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Kuliner";
    private static final String tb_jenis_Kuliner = "tb_jenis_Kuliner";
    private static final String tb_id_Kuliner = "id";
    private static final String tb_nama_Kuliner = "nama";
    private static final String tb_asal_Kuliner = "asal";
    private static final String tb_deskripsi = "deskripsi";
    private static final String CREATE_TABLE_jenis_Kuliner = "CREATE TABLE " +
            tb_jenis_Kuliner + "("
            + tb_id_Kuliner + " INTEGER PRIMARY KEY ,"
            + tb_nama_Kuliner + " TEXT,"
            + tb_asal_Kuliner + " TEXT,"
            + tb_deskripsi + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_jenis_Kuliner);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateKuliner (Kuliner mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_id_Kuliner, mdNotif.get_id());
        values.put(tb_nama_Kuliner, mdNotif.get_nama());
        values.put(tb_asal_Kuliner, mdNotif.get_asal());
        values.put(tb_deskripsi, mdNotif.get_deskripsi());
        db.insert(tb_jenis_Kuliner, null, values);
        db.close();
    }

    public List<Kuliner> ReadKuliner() {
        List<Kuliner> namaModelList = new ArrayList<Kuliner>();
        String selectQuery = "SELECT * FROM " + tb_jenis_Kuliner;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kuliner mdKontak = new Kuliner();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_asal(cursor.getString(2));
                mdKontak.set_deskripsi(cursor.getString(3));
                namaModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return namaModelList;
    }
    public int UpdateKuliner (Kuliner mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_nama_Kuliner, mdNotif.get_nama());
        values.put(tb_asal_Kuliner, mdNotif.get_asal());
        values.put(tb_deskripsi, mdNotif.get_deskripsi());
        return db.update(tb_jenis_Kuliner, values, tb_id_Kuliner + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteKuliner (Kuliner mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_jenis_Kuliner, tb_id_Kuliner+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
