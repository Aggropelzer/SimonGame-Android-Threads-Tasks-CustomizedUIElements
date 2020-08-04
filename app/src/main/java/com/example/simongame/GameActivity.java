package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    TextView gameInfoView;
    private int mode;
    private String playerOneName = "";
    private String playerTwoName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
      //  getSupportActionBar().setIcon(R.mipmap.ic_launcher);
      //  getSupportActionBar().setTitle("GAME");

        gameInfoView = findViewById(R.id.gameInfoView);

        // Opens the input of the previous Intent
        Intent intent = getIntent();
        mode = intent.getIntExtra("mode",-1);
        playerOneName = intent.getStringExtra("playerOneName");

        if(mode != 1) {
            playerTwoName = intent.getStringExtra("playerTwoName");
        }

        gameInfoView.setText("Bier "+mode);
    }
}
