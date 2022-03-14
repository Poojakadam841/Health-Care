package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, user_name, phone, pass_word;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    TextInputLayout nameError, emailError, phoneError, passError;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText) findViewById(R.id.name);
        user_name = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        pass_word = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        nameError = (TextInputLayout) findViewById(R.id.nameError);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        phoneError = (TextInputLayout) findViewById(R.id.phoneError);
        passError = (TextInputLayout) findViewById(R.id.passError);
        mAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

           
    }




    public void SetValidation() {
        // Check for a valid name.
        String email = user_name.getText().toString().trim();
        String password= pass_word.getText().toString().trim();
        if (name.getText().toString().isEmpty()) {
            nameError.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else {
            isNameValid = true;
            nameError.setErrorEnabled(false);
        }

        // Check for a valid email address.
        if (user_name.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(user_name.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phoneError.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else {
            isPhoneValid = true;
            phoneError.setErrorEnabled(false);
        }

        // Check for a valid password.
        if (pass_word.getText().toString().isEmpty()) {
            passError.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (pass_word.getText().length() < 6) {
            passError.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegistrationActivity.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationActivity.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





