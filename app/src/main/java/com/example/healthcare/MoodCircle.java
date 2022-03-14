package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ramotion.circlemenu.CircleMenuView;

public class MoodCircle extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_circle);
        final CircleMenuView menu = findViewById(R.id.circle_menu);

        text = (TextView) findViewById(R.id.textView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), Task.class);
                startActivity(intent);
            }

        });

        menu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationStart");
                Toast.makeText(MoodCircle.this, "change the world by being yourself", Toast.LENGTH_SHORT).show();
            }            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationEnd");
            }            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationStart");
            }            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationEnd");
            }            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D","onButtonClickAnimationStart|index: "+index);
            }            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D","onButtonClickAnimationEnd|index: "+index);
            }            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClick|index: "+buttonIndex);
                return true;
            }
            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClickAnimationStart|index: "+buttonIndex);
            }            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClickAnimationEnd|index: "+buttonIndex);
            }
        });    }
}

