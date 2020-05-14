package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity7_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity7_1);
    }
    private void previous(View view)
    {
        Intent i=new Intent(this, Activity7.class);
        startActivity(i);
    }
}
