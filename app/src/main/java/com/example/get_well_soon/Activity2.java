package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    private void next(View view)
    {
        Intent i=new Intent(this, Activity2_1.class);
        startActivity(i);
    }

    private void previous(View view)
    {
        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
}
