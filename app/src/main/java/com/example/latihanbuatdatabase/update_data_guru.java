package com.example.latihanbuatdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_data_guru extends AppCompatActivity implements View.OnClickListener{
    EditText ednip,ednama,edstatus,edalamat,edkota;
    Button btnupdate,btndelete,btnview;
    DataBaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_guru);
        ednip = findViewById(R.id.editnip);
        ednama = findViewById(R.id.editnama);
        edstatus = findViewById(R.id.editstatus);
        edalamat = findViewById(R.id.editalamat);
        edkota = findViewById(R.id.editkota);

        btnupdate = findViewById(R.id.tombolupdate);
        btndelete = findViewById(R.id.tomboldelete);
        btnview = findViewById(R.id.tombolview);

        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnview.setOnClickListener(this);
        dbh = new DataBaseHelper(this);

        Bundle bundle = getIntent().getExtras();

        ednip.setText(bundle.getString("nip"));
        ednama.setText(bundle.getString("nama"));
        edstatus.setText(bundle.getString("status"));
        edalamat.setText(bundle.getString("alamat"));
        edkota.setText(bundle.getString("kota"));
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tombolupdate)
        {
            //update
            String xnip = ednip.getText().toString();
            String xnama = ednama.getText().toString();
            String xstatus = edstatus.getText().toString();
            String xalamat = edalamat.getText().toString();
            String xkota = edkota.getText().toString();
            boolean okedeh = dbh.update_dataguru(xnip,xnama,xstatus,xalamat,xkota);
            if(okedeh)
            {
                Toast.makeText(this,"Update Suksess !!", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this,"Update Gagal Nich !!", Toast.LENGTH_SHORT).show();
            }

        }else if(view.getId()==R.id.tomboldelete)
        {
            //delete
            String xnip = ednip.getText().toString();
            boolean okelah = dbh.hapus_dataguru(xnip);
            if(okelah)
            {
                Toast.makeText(this,"Delete Suksess !!", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this,"Delete Gagal Nich !!", Toast.LENGTH_SHORT).show();
            }

        }else
        {
            //view
            Intent intent = new Intent(update_data_guru.this, BacaSqLite.class);
            startActivity(intent);
        }
    }
}