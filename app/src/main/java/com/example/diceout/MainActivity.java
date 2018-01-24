package com.example.diceout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //field to hold the roll result text
    TextView rollResult;

    //field to hold the roll button

    Button rollButton;

    //field to hold the scores
    int score;

    Random rand;

    //fields to hold the dices
    int die1;
    int die2;
    int die3;

    ArrayList<Integer> dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initial score
        score = 0;

        rollResult = findViewById(R.id.rollResult);
        rollButton = findViewById(R.id.rollButton);

        //random number for the dice
        rand = new Random();

        Toast.makeText(getApplicationContext(),"Welcome to Dice Out!",Toast.LENGTH_SHORT).show();

        //create an arraylist to hold the dice values
        dice = new ArrayList<Integer>();
    }

    public void rollDice(View v)
    {
        rollResult.setText("Clicked");

        //roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //set values to the arraylist
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        //build the message with the result
        String msg = "You rolled a " + die1 + ", a " + die2 + ", and a " + die3 + ".";

        rollResult.setText(msg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
