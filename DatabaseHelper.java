package com.example.stockmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




    public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DB_NAME = "ERP_MASTER";


        public static final int DB_VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE product_items( pid VARCHAR(50) PRIMARY KEY, product_name VARCHAR(100))";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS product_items";
            db.execSQL(sql);
            onCreate(db);
        }


        //WAIT ONLINE... I WILL COLLECT SOME CODE FROM MY ANDROID STUDIO
        public boolean addUser(SQLiteDatabase db,String name){
            try {


                ContentValues contentValues = new ContentValues();
                contentValues.put("pid", (get_product_items_count(db)+1));
                contentValues.put("product_name", name);
                db.insert("product_items", null, contentValues);
                return true;
            }
            catch(Exception exception)
            {
                return false;
            }

        }

        public int get_product_items_count(SQLiteDatabase db)
        {
            Cursor cursor =  db.rawQuery( "SELECT couont(*) FROM product_items" ,null);
            cursor.moveToFirst();
            return cursor.getInt(0);

        }

        public int get_product_items(SQLiteDatabase db,String product_name)
        {
            Cursor cursor =  db.rawQuery( "SELECT * FROM product_items where product_name='"+product_name+"'" ,null);
            cursor.moveToFirst();
            return cursor.getCount();

        }
    }




