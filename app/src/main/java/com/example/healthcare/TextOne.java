package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextOne extends AppCompatActivity implements View.OnClickListener {
    TextView textsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_one);
        textsecond = (TextView) findViewById(R.id.task2);
        textsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), TaskSecond.class);
                startActivity(intent);
            }
        });


        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
        Button button13 = findViewById(R.id.button13);
        Button button14 = findViewById(R.id.button14);
        Button button15 = findViewById(R.id.button15);
        Button button16 = findViewById(R.id.button16);
        Button button17 = findViewById(R.id.button17);
        Button button18 = findViewById(R.id.button18);
        Button button19 = findViewById(R.id.button19);
        Button button20 = findViewById(R.id.button20);

        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
        button18.setOnClickListener(this);
        button19.setOnClickListener(this);
        button20.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                Toast.makeText(this, "Budget 20 minutes of at home spa time", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button12:
                Toast.makeText(this, "practice a favorite hobby", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button13:
                Toast.makeText(this, "get distracted by a movie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button14:
                Toast.makeText(this, "go to bed 30 minutes eariler", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button15:
                Toast.makeText(this, "drink just water today", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button16:
                Toast.makeText(this, "schedule a game night", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button17:
                Toast.makeText(this, "set amini goal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button18:
                Toast.makeText(this, "cross an item off your to-do list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button19:
                Toast.makeText(this, "compliment someone", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button20:
                Toast.makeText(this, "plan a zoom catch-up with firends", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    }
