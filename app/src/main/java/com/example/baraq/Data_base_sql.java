package com.example.baraq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class Data_base_sql  extends SQLiteOpenHelper {

    private static final String details_col ="details_col";
    private static final String imageurl_col="image_url_col";
    private static final String table_name="books_table";
    private static final String db_name="books_db";
    public Data_base_sql(@Nullable Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+table_name+"( id INTEGER PRIMARY KEY AUTOINCREMENT,"+details_col+" TEXT,"+imageurl_col+" TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(book_Model book){
        ContentValues values =new ContentValues();
        SQLiteDatabase db=getWritableDatabase();
        values.put(imageurl_col,book.getImage_url());
        values.put(details_col,book.getPuplsher_name());
        long b=db.insert(table_name,null,values);
        return b!=-1;
    }
    public ArrayList getalldata(){
        ArrayList<book_Model>arrayList1=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+table_name,null);
        if (c.moveToFirst()){
            do {
                String details=c.getString(c.getColumnIndex(details_col));
                String image_url=c.getString(c.getColumnIndex(imageurl_col));
                book_Model b=new book_Model(image_url,details);
                arrayList1.add(b);
            }while (c.moveToNext());
            c.close();
        }
        return arrayList1;
    }
}
