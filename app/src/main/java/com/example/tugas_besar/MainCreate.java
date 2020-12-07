package com.example.tugas_besar;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class MainCreate extends AppCompatActivity {

    private MyDatabase db;
    private EditText Enama, Easal, Edeskripsi;
    private String Snama, Sasal, Sdeskripsi;


    public static void start(Context context) {
        Intent intent = new Intent(context, MainCreate.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Easal = (EditText) findViewById(R.id.create_asal);
        Edeskripsi = (EditText) findViewById(R.id.create_deskripsi);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sasal = String.valueOf(Easal.getText());
                Sdeskripsi = String.valueOf(Edeskripsi.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sasal.equals("")){
                    Easal.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi asal",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdeskripsi.equals("")){
                    Edeskripsi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi deskripsi",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Easal.setText("");
                    Edeskripsi.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateKuliner(new Kuliner(null, Snama, Sasal, Sdeskripsi));
                    Intent a = new Intent(MainCreate.this, MainRead.class);
                    startActivity(a);
                }
            }
        });


    }
}