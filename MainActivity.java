package com.example.goodminesweeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)  findViewById(R.id.button);
    }

    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this, EasyGame.class);
        startActivity(intent);
    }
}