package com.example.get_well_soon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details_of_doctor extends AppCompatActivity {
    Button logout;
    DatabaseReference  reff;
    FirebaseAuth mAuth;
    FirebaseUser current;
    String city="";
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();

        setContentView(R.layout.activity_details_of_doctor);
        mAuth=FirebaseAuth.getInstance();
        current=mAuth.getCurrentUser();
        t1=findViewById(R.id.textView13);
        city=getIntent().getStringExtra("city");
        logout=(Button)findViewById(R.id.logout_doctor);







        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mAuth.signOut();

                startActivity(new Intent(details_of_doctor.this, MainActivity.class));
            }
        });
    }
}
