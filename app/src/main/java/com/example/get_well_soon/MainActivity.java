package com.example.get_well_soon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button signin,register;
    String user="patient",phone1="",pass1="",city1="";
    ToggleButton userChoice;
    TextView useAs;
    DatabaseReference reff;
    EditText email,pass,city,phone;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reff=FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();

        useAs=(TextView)findViewById(R.id.textView11);
        signin=(Button)findViewById(R.id.signin);
        register=(Button)findViewById(R.id.register);
        phone=(EditText)findViewById(R.id.phoneForLogin);
        pass=(EditText)findViewById(R.id.passForLogin);
        city=(EditText)findViewById(R.id.cityForLogin);


        userChoice=(ToggleButton)findViewById(R.id.toggleButton);
        userChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userChoice.isChecked())
                {
                    user="doctor";
                    useAs.setText("Welcome Doctor");
                    

                }
                else
                {
                    user="patient";
                    useAs.setText("Welcome Patient");
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.equalsIgnoreCase("patient"))
                    startActivity(new Intent(MainActivity.this, patient_registeration.class));
                else if(user.equalsIgnoreCase("doctor"))
                    startActivity(new Intent(MainActivity.this, Activity2.class));
            }
        });
        reff= FirebaseDatabase.getInstance().getReference();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone1=phone.getText().toString().trim();
                pass1=pass.getText().toString().trim();
                city1=city.getText().toString().trim().toLowerCase();
                if(user.equalsIgnoreCase("patient"))
                {
                    patientSignIN();

                }
                else if(user.equalsIgnoreCase("doctor"))
                {
                    doctorSignIN();
               }
            }
        });
    }
    protected void doctorSignIN()
    {

        reff.child(city1.toLowerCase()).child("Doctor").child(phone1).child("pass").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             if(dataSnapshot.getValue()!=null) {
                 String passStored = dataSnapshot.getValue().toString();
                 if (pass1.equals(passStored)) {
                     Toast.makeText(MainActivity.this, "Doctor Login Successfull", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(MainActivity.this, details_of_doctor.class));
                 } else {
                     Toast.makeText(MainActivity.this, "Incorrect Phone number or Password", Toast.LENGTH_SHORT).show();
                 }
             }
             else
             {
                 Toast.makeText(MainActivity.this, "No user Found", Toast.LENGTH_SHORT).show();
             }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "No user Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void patientSignIN()
    {
        reff.child(city1.toLowerCase()).child("Patient").child(phone1).child("pass").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()!=null) {
                    String passStored = dataSnapshot.getValue().toString();
                    if (pass1.equals(passStored)) {
                        Toast.makeText(MainActivity.this, "Patient Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Activity7.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Incorrect Phone number or Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No user Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "No user Found", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
