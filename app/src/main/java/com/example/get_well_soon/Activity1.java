package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.get_well_soon.ui.login.LoginActivity;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }
    public void sign(View view)
    {
        Intent i=new Intent(this, LoginActivity.class);
        startActivity(i);
    }
    public void register(View view)
    {
        Intent i=new Intent(this, Activity2.class);
        startActivity(i);
    }
    public void back(View view)
    {
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
