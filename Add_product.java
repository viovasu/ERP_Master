package com.example.stockmanagement;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Add_product extends AppCompatActivity
{

    public DatabaseHelper db;
    private EditText editTextName;


    public SQLiteDatabase sql_db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        db = new DatabaseHelper(this);
        sql_db =  db.getWritableDatabase();

        editTextName = (EditText) findViewById(R.id.textViewName);
    }


    public void add_user_clicked(View view)
    {

        String name=((EditText) findViewById(R.id.textViewName)).getText().toString().toLowerCase().trim();
        Toast.makeText(Add_product.this,"*"+name+"*",Toast.LENGTH_LONG).show();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "please enter the name", Toast.LENGTH_LONG).show();

        }
        else
            {

                int count = db.get_product_items(sql_db,name);
            if ( count == 0 )
            {
                db.addUser(sql_db, name);
                Toast.makeText(this, "Product Added.", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Product Already Exists", Toast.LENGTH_LONG).show();
            }
        }
    }
}
