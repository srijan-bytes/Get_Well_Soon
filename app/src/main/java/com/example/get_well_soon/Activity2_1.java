package com.example.get_well_soon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class Activity2_1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView userlocation;
    LocationManager locationManager ;
    LocationListener locationListener;
    Button previous,verify;
    String phonenumber="";
    EditText phone,description,otp;
    String name1="",degree1="",college1="",fees1="",opentime1="",closetime1="",email1="",pass1="",specialization1="",
            description1="",location1="",phone1="",city1="";
    Button register;
    DatabaseReference reff;
    Doctor doctor;
    String verificationCodeBySystem="";

    Button check,checkotp;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
                 locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0, locationListener);
        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_1);
        spinner=(Spinner)findViewById(R.id.spinner211);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.specialization , android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        userlocation=findViewById(R.id.editText5);
        userlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        previous=(Button)findViewById(R.id.b211);
        phone=(EditText) findViewById(R.id.editText6);
        verify=(Button)findViewById(R.id.b212);

        spinner=(Spinner)findViewById(R.id.spinner211);
        description=(EditText)findViewById(R.id.editText4);
        description1=description.getText().toString();
        phonenumber=phone.getText().toString();
        specialization1=spinner.getSelectedItem().toString();

        location1=userlocation.getText().toString();

        otp=(EditText)findViewById(R.id.editText9);
        checkotp=(Button)findViewById(R.id.b214);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2_1.this, Activity2.class));
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(phonenumber!="")
                {
                    phone1=phone.getText().toString().trim();
                    sendVerificationCodeToUser(phone.getText().toString().trim());

                }
                else
                {
                    Toast.makeText(Activity2_1.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }


            }
        });
        register=(Button)findViewById(R.id.b213);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                Toast.makeText(Activity2_1.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Activity2_1.this, MainActivity.class);
                startActivity(intent);

            }
        });
        checkotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = otp.getText().toString();

                if (code.isEmpty() || code.length() < 6) {
                    otp.setError("Wrong OTP...");
                    otp.requestFocus();
                    return;
                }

                verifyCode(code);
            }
        });


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void getLocation() {

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                userlocation.setText(location.toString());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else
        {
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,0,0, locationListener);
        }
    }
    protected void registerUser()
    {
        doctor=new Doctor();
        setContentView(R.layout.activity_4);
        city1=getIntent().getStringExtra("city");
        description1=description.getText().toString();
        reff= FirebaseDatabase.getInstance().getReference().child(city1).child(phone1);
        name1=getIntent().getStringExtra("name");
        degree1=getIntent().getStringExtra("degree");
        college1=getIntent().getStringExtra("college");
        fees1=getIntent().getStringExtra("fees");
        opentime1=getIntent().getStringExtra("opentime");
        closetime1=getIntent().getStringExtra("closetime");
        pass1=getIntent().getStringExtra("pass");


        email1=getIntent().getStringExtra("email");

        doctor.setName(name1);
        doctor.setDegree(degree1);
        doctor.setCollege(college1);
        doctor.setFees(fees1);
        doctor.setOpentime(opentime1);
        doctor.setClosetime(closetime1);
        doctor.setPass(pass1);
        doctor.setDescription(description1);
        doctor.setSpecialization(specialization1);
        doctor.setLocation(location1);
        doctor.setPhone(phone1);
        doctor.setEmail(email1);
        doctor.setCity(city1);
        reff.push().setValue(doctor);
    }
    private void sendVerificationCodeToUser(String phoneNo) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+phoneNo,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,   // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {

                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(Activity2_1.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("OTP", e.getMessage());
        }
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            //Get the code in global variable
            verificationCodeBySystem = s;
        }
    };

    private void verifyCode(String codeByUser) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCodeBySystem, codeByUser);
        signInTheUserByCredentials(credential);

    }
    private void signInTheUserByCredentials(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(Activity2_1.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {


                            //Perform Your required action here to either let the user sign In or do something required
                            Toast.makeText(Activity2_1.this, "Phone Number is Successfully Verified", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Activity2_1.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}


