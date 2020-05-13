package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doctor(View view)
    {
        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }

    public void patient(View view)
    {
        Intent i=new Intent(this, Activity7.class);
        startActivity(i);
    }

}
