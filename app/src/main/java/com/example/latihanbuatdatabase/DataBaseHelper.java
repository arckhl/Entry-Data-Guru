package com.example.latihanbuatdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public final static String NAMA_DATABASE="AKADEMIK";
    public final static String NAMA_TABEL="DataGuru";
    public final static String field01="nip";
    public final static String field02="nama";
    public final static String field03="status";
    public final static String field04="alamat";
    public final static String field05="kota";

    public DataBaseHelper(Context context) {
        super(context, NAMA_DATABASE, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABEL+"(nip text primary key," +
                "nama text," +
                "status text," +
                "alamat text," +
                "kota text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABEL);
        onCreate(db);
    }

    public boolean update_dataguru(String xnip, String xnama, String xstatus, String xalamat, String xkota) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(field01,xnip);
        cv.put(field02,xnama);
        cv.put(field03,xstatus);
        cv.put(field04,xalamat);
        cv.put(field05,xkota);

        long berhasil = db.update(NAMA_TABEL,cv,"nip=?",new String[]{xnip});
        if(berhasil > 0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public boolean hapus_dataguru(String xnip) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(field01,xnip);
        long berhasil = db.delete(NAMA_TABEL,"nip=?",new String[]{xnip});
        if(berhasil > 0)
        {
            return true;
        }else
        {
            return false;
        }
    }


    public Cursor baca_data() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+NAMA_TABEL,null);
        return cur;
    }


    public long input_dataguru(String xnip, String xnama, String xstatus, String xalamat, String xkota) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(field01,xnip);
        cv.put(field02,xnama);
        cv.put(field03,xstatus);
        cv.put(field04,xalamat);
        cv.put(field05,xkota);

        long oke=db.insert(NAMA_TABEL,null,cv);
        return oke;
    }
}
