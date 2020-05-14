package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity7 extends AppCompatActivity {
    Button previous,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        previous=findViewById(R.id.b71);
        next=findViewById(R.id.b72);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }
    private void previous()
    {

        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void next()
    {
        Intent i=new Intent(this, Activity7_1.class);
        startActivity(i);
    }
}
