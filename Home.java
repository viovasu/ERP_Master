package com.example.stockmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class Home extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

public void buttonAdd(View view)
{
    Intent i=new Intent(Home.this, Add_product.class);
    startActivity(i);

}
}
