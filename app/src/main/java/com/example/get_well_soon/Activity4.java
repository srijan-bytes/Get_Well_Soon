package com.example.get_well_soon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity4 extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth.getInstance().signOut();
        setContentView(R.layout.activity_4);
        mAuth=FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(getIntent().getStringExtra("email"),getIntent().getStringExtra("pass"));
        exit=(Button)findViewById(R.id.button);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity4.this, MainActivity.class));
            }
        });

    }
}
