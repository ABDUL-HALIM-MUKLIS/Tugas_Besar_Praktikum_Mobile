package com.example.tugas_besar;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sasal, Sdeskripsi;
    private EditText Enama, Easal, Edeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sasal = i.getStringExtra("Iasal");
        Sdeskripsi = i.getStringExtra("Ideskripsi");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Easal = (EditText) findViewById(R.id.updel_asal);
        Edeskripsi = (EditText) findViewById(R.id.updel_deskripsi);
        Enama.setText(Snama);
        Easal.setText(Sasal);
        Edeskripsi.setText(Sdeskripsi);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sasal = String.valueOf(Easal.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama Kuliner",
                            Toast.LENGTH_SHORT).show();
                } else if (Sasal.equals("")){
                    Easal.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi asal",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdeskripsi.equals("")){
                    Edeskripsi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi deskripsi",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateKuliner(new Kuliner(Sid, Snama, Sasal, Sdeskripsi));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteKuliner(new Kuliner(Sid, Snama, Sasal, Sdeskripsi));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

