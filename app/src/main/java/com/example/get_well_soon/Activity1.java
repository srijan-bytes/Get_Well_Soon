package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.get_well_soon.ui.login.LoginActivity;

public class Activity1 extends AppCompatActivity {
    Button sign,register,previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        sign=findViewById(R.id.b11);
        register=findViewById(R.id.b12);
        previous=findViewById(R.id.b13);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });
    }
    public void sign()
    {
        Intent i=new Intent(this, LoginActivity.class);
        startActivity(i);
    }
    public void register()
    {
        Intent i=new Intent(this, Activity2.class);
        startActivity(i);
    }
    public void previous()
    {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
