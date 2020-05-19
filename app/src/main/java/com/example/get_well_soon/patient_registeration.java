package com.example.get_well_soon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class patient_registeration extends AppCompatActivity {
    EditText name,email,pass,phone,otpInput,city;
    String phoneNumber="",otp="",verificationCodeBySystem ="";
    Button verify,checkOTP,register;
    DatabaseReference reff;
    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registeration);
        name=(EditText)findViewById(R.id.name_patient);
        email=(EditText)findViewById(R.id.email_patient);
        pass=(EditText)findViewById(R.id.pass_patient);
        phone=(EditText)findViewById(R.id.phoone_patient);
        otpInput=(EditText)findViewById(R.id.otp_patient);
        city=(EditText)findViewById(R.id.city_patient);
        verify=(Button)findViewById(R.id.button2);
        checkOTP=(Button)findViewById(R.id.button3);
        register=(Button)findViewById(R.id.button6);
         verify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 phoneNumber=phone.getText().toString().trim();
                 if(phoneNumber!="")
                 {

                     sendVerificationCodeToUser(phoneNumber);

                 }
                 else
                 {
                     Toast.makeText(patient_registeration.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                 }
             }
         });
         checkOTP.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String code = otpInput.getText().toString();

                 if (code.isEmpty() || code.length() < 6) {
                     otpInput.setError("Wrong OTP...");
                     otpInput.requestFocus();
                     return;
                 }

                 verifyCode(code);
             }
         });
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 registerPatient();
                 Toast.makeText(patient_registeration.this, "Patient Added Successfully", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(patient_registeration.this, MainActivity.class));
             }
         });
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
            Toast.makeText(patient_registeration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
                .addOnCompleteListener(patient_registeration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {


                            //Perform Your required action here to either let the user sign In or do something required
                            Toast.makeText(patient_registeration.this, "Phone Number is Successfully Verified", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(patient_registeration.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    protected void registerPatient()
    {
        String cityname=city.getText().toString().trim().toLowerCase();
        reff= FirebaseDatabase.getInstance().getReference();
        patient=new Patient();
        patient.setName(name.getText().toString().trim());
        patient.setEmail(email.getText().toString().trim());
        patient.setPass(pass.getText().toString().trim());
        patient.setPhone(phone.getText().toString().trim());
        patient.setCity(cityname);
        reff.child(cityname).child("Patient").child(phone.getText().toString().trim()).setValue(patient);
    }
}
