package com.example.tugas_besar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView .OnItemClickListener{
    private FloatingActionButton fab;
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Kuliner> ListKuliner = new ArrayList<Kuliner>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListKuliner );
        mListView = (ListView) findViewById(R.id.list_Kuliner);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKuliner.clear();
        List<Kuliner> contacts = db.ReadKuliner();
        for (Kuliner cn : contacts) {
            Kuliner namaModel = new Kuliner();
            namaModel.set_id(cn.get_id());
            namaModel.set_nama(cn.get_nama());
            namaModel.set_asal(cn.get_asal());
            namaModel.set_deskripsi(cn.get_deskripsi());
            ListKuliner.add(namaModel);
            if ((ListKuliner.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }

        fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainCreate.start(MainRead.this);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Kuliner obj_itemDetails = (Kuliner)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sasal = obj_itemDetails.get_asal();
        String Sdeskripsi = obj_itemDetails.get_deskripsi();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iasal", Sasal);
        goUpdel.putExtra("Ideskripsi", Sdeskripsi);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKuliner.clear();
        mListView.setAdapter(adapter_off);
        List<Kuliner> contacts = db.ReadKuliner();
        for (Kuliner cn : contacts) {
            Kuliner namaModel = new Kuliner();
            namaModel.set_id(cn.get_id());
            namaModel.set_nama(cn.get_nama());
            namaModel.set_asal(cn.get_asal());
            namaModel.set_deskripsi(cn.get_deskripsi());
            ListKuliner.add(namaModel);
            if ((ListKuliner.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }







}
