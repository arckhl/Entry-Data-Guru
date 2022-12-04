package com.example.latihanbuatdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BacaSqLite extends AppCompatActivity {
    Button tombolmasuk;
    RecyclerView recyclerViewGuru;
    ArrayList<ModelDataGuru> dataguruArrayList=new ArrayList<>();
    DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sq_lite);

        tombolmasuk=findViewById(R.id.buttoninput);
        dbh=new DataBaseHelper(this);
        recyclerViewGuru=findViewById(R.id.recyclerview_dataguru);

        Cursor cursor=dbh.baca_data();
        //Toast.makeText(this, "Jumlah Data\t"+cursor.getCount(), Toast.LENGTH_LONG).show();
        cursor.moveToPrevious();
        while (cursor.moveToNext()){
            dataguruArrayList.add(new ModelDataGuru(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)));
        }
        AdapterDataGuru adapterDataGuru=new AdapterDataGuru(this,dataguruArrayList);
        recyclerViewGuru.setAdapter(adapterDataGuru);
        recyclerViewGuru.setLayoutManager(new LinearLayoutManager(this));


        tombolmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BacaSqLite.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}