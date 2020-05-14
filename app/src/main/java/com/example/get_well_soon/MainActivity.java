package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button doctor,patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doctor=findViewById(R.id.b01);
        patient=findViewById(R.id.b02);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor();
            }
        });
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient();
            }
        });
    }
    public void doctor()
    {
        Intent i=new Intent(this, Activity1.class);
        startActivity(i);
    }

    public void patient()
    {
        Intent i=new Intent(this, Activity7.class);
        startActivity(i);
    }

}
