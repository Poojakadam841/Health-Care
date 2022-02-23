package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskSecond extends AppCompatActivity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_second);
        textView = (TextView) findViewById(R.id.task3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), ToDoList.class);
                startActivity(intent);
            }
        });
        Button button21 = findViewById(R.id.button21);
        Button button22 = findViewById(R.id.button22);
        Button button23 = findViewById(R.id.button23);
        Button button24 = findViewById(R.id.button24);
        Button button25 = findViewById(R.id.button25);
        Button button26 = findViewById(R.id.button26);
        Button button27 = findViewById(R.id.button27);
        Button button28 = findViewById(R.id.button28);
        Button button29 = findViewById(R.id.button29);
        Button button30 = findViewById(R.id.button30);

        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button24.setOnClickListener(this);
        button25.setOnClickListener(this);
        button26.setOnClickListener(this);
        button27.setOnClickListener(this);
        button28.setOnClickListener(this);
        button29.setOnClickListener(this);
        button30.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button21:
                Toast.makeText(this, "try a 5-minute meditation", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button22:
                Toast.makeText(this, "face time with family", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button23:
                Toast.makeText(this, "do something outside", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button24:
                Toast.makeText(this, "order in and watch a movie with yourfamily,friends", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button25:
                Toast.makeText(this, "unfollow negative social media accounts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button26:
                Toast.makeText(this, "say no to something", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button27:
                Toast.makeText(this, "have a phone free night", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button28:
                Toast.makeText(this, "watch a silly video", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button29:
                Toast.makeText(this, "write down something good that happened", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button30:
                Toast.makeText(this, "adopt a new habit", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    }
