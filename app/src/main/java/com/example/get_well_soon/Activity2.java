package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    Button next,previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        next=(Button)findViewById(R.id.b22);
        previous=(Button)findViewById(R.id.b21);
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
    private void next()
    {
        Intent i=new Intent(this, Activity2_1.class);
        startActivity(i);
    }

    private void previous()
    {
        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }
}
