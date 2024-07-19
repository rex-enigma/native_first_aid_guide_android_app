package com.example.firstaidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstaidapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();

        Runnable navigateRunnable = new Runnable() {
            // navigate the user to the gridView after 3 sec
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(navigateRunnable,2000);

    }
}