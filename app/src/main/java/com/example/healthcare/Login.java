package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    EditText user_name, pass_word;
    Button login;
    TextView register;
    boolean isEmailValid, isPasswordValid;
    TextInputLayout emailError, passError;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_name = (EditText) findViewById(R.id.email);
        pass_word = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        passError = (TextInputLayout) findViewById(R.id.passError);
        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }

        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid email address.
        login.setOnClickListener(v -> {
            String email = user_name.getText().toString().trim();
            String password = pass_word.getText().toString().trim();

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

            if (isEmailValid && isPasswordValid) {
                Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();

            }
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    startActivity(new Intent(Login.this, MoodCircle.class));
                } else {
                    Toast.makeText(Login.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });

        });
    }
}
    // drawer layout instance to toggle the menu icon to open
    // drawer and back button to close drawer







