package com.example.latihanbuatdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText enip,enama,estatus,ealamat,ekota;
    Button buttonsimpan,buttonview;
    DataBaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enip = findViewById(R.id.editnip);
        enama = findViewById(R.id.editnama);
        estatus = findViewById(R.id.editstatus);
        ealamat = findViewById(R.id.editalamat);
        ekota = findViewById(R.id.editskota);

        buttonsimpan = findViewById(R.id.tombolsave);
        buttonview = findViewById(R.id.tombolview);

        buttonsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xnip=enip.getText().toString();
                String xnama=enama.getText().toString();
                String xstatus=estatus.getText().toString();
                String xalamat=ealamat.getText().toString();
                String xkota = ekota.getText().toString();

                long hasil= dbh.input_dataguru(xnip,xnama,xstatus,xalamat,xkota);
                if(hasil>0)
                {
                    Toast.makeText(MainActivity.this, "Suksess Simpan !", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "Simpan Gagal !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}