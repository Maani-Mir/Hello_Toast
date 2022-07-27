package com.example.hello_toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private int count = 0;
    private TextView showcount;
    public static final String EXTRA_MESSAGE = ".extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showcount = (TextView) findViewById(R.id.show_count);
        Toast.makeText(this, "onCreate Finished", Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onCreate");
    }

    public void showToast(View view) {
        Toast mesg = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG);
        mesg.show();
    }

    public void showCount(View view) {
        count++;
        if(showcount != null)
            showcount.setText(String.format(Locale.getDefault(), "%d", count)); // this takes the
            //showcount.setText(Integer.toString(count));
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondScreen.class);
        String message = showcount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
        Toast.makeText(this, "Launch Activity ends and Second Screen starts", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity","LA ends and SS starts");
    }
}