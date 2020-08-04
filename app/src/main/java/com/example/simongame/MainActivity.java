package com.example.simongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtPlayerOne;
    private EditText edtPlayerTwo;
    private boolean twoPlayer = false;
    private Button btnActivateTwoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);

        // I must credit the Name of the author of this SVG Item

        // <div>Icons made by <a href="https://www.flaticon.com/authors/creaticca-creative-agency"
        // title="Creaticca Creative Agency">Creaticca Creative Agency</a>
        // from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

      //  getSupportActionBar().setIcon(R.mipmap.ic_launcher);
       // getSupportActionBar().setTitle("START GAME");

        edtPlayerOne = findViewById(R.id.editPlayerOne);
        edtPlayerTwo = findViewById(R.id.editPlayerTwo);

        btnActivateTwoPlayer = findViewById(R.id.activatePlayerButton);

        //hide Player 2 Name editText
        edtPlayerTwo.setAlpha(0.0f);
    }
    public void onTwoPlayer(View w){
        if (twoPlayer == false) {
            twoPlayer = true;
            //show Player 2 Name editText
            edtPlayerTwo.setAlpha(1.0f);
            edtPlayerTwo.requestFocus();
            btnActivateTwoPlayer.setText("Activate One Player Mode");
            Toast.makeText(MainActivity.this,
                    "Activated Two Player",
                    Toast.LENGTH_LONG).show();
        }
        else {
            twoPlayer = false;
            edtPlayerTwo.setAlpha(0.0f);
            edtPlayerOne.requestFocus();
            btnActivateTwoPlayer.setText("Activate Two Player Mode");
            Toast.makeText(MainActivity.this,
                    "Activated Single Player",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void onStartGame(View w){

        if(twoPlayer == false) {
            if (edtPlayerOne.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this,
                        "Please Enter Player Name",
                        Toast.LENGTH_LONG).show();
                edtPlayerOne.requestFocus();
            } else {
                Intent startGameIntent = new Intent(MainActivity.this,
                        GameActivity.class);

                startGameIntent.putExtra("playerOneName", edtPlayerOne.getText().toString());
                startGameIntent.putExtra("mode",1);

                Toast.makeText(MainActivity.this,
                        "Single Player Game started",
                        Toast.LENGTH_SHORT).show();

                startActivity(startGameIntent);
            }
        }
        else{
            if(edtPlayerOne.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,
                        "Please Enter Player Name",
                        Toast.LENGTH_LONG).show();
                edtPlayerOne.requestFocus();
            }
            else if(edtPlayerTwo.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,
                        "Please Enter the second Player Name",
                        Toast.LENGTH_LONG).show();
                edtPlayerTwo.requestFocus();
            }
            else{
                Intent startGameIntent = new Intent(MainActivity.this, GameActivity.class);

                startGameIntent.putExtra("playerOneName", edtPlayerOne.getText().toString());
                startGameIntent.putExtra("playerTwoName",edtPlayerTwo.getText().toString());
                startGameIntent.putExtra("mode",2);

                Toast.makeText(MainActivity.this,
                        "Two Player Game started",
                        Toast.LENGTH_SHORT).show();

                startActivity(startGameIntent);
            }
            }
        }
    }

