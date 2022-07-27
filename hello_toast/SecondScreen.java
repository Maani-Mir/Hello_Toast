package com.example.hello_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView secondCount = findViewById(R.id.show_count_2);
        secondCount.setText(message);
        Toast.makeText(this, "Second Screen Finished", Toast.LENGTH_LONG).show();
        Log.i("SecondScreen","SS Finished");
    }
}