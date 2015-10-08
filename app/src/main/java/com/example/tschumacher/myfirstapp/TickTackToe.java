package com.example.tschumacher.myfirstapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TickTackToe extends AppCompatActivity {
    int counter;
    int winner;
    String [][] board = new String [3][3];
    Button[] buttons = new Button[10];
    int [] index = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_tack_toe);

    }

    protected void onStart() {
        super.onStart();

        for (int k = 0; k < 3; k++){
            for (int m = 0; m < 3; m++) {
                board[k][m] = "-";
            }
        }
        winner = 0;
        counter = 0;
        int j  = 0;
        for (int i = R.id.button1; i <= R.id.button_result; i++){
            index[j] = i;
            j++;
        }
        for (int i  =  0; i < 10; i++){
            Drawable background = findViewById(R.id.restart).getBackground();
            if (9 == i){
                buttons[i] = (Button) findViewById(index[i]);
                buttons[i].setText("Result");
            }
            else {
                buttons[i] = (Button) findViewById(index[i]);
                buttons[i].setText("-");
                buttons[i].setClickable(true);
                buttons[i].setBackgroundColor(Color.LTGRAY);
                buttons[i].setBackground(background);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tick_tack_toe, menu);
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
    public void click (View view) {

        String[] myArr = {"X", "O"};
        int player;

        if (view instanceof Button) {
            Button button = (Button) view;
            button.setText(myArr[counter % 2]);
            button.setBackgroundColor(Color.CYAN);
            button.setClickable(false);
            for (int k = 0; k < 9; k++){
                if (buttons[k] == button){
                    board[Math.abs(k / 3)][k % 3] = myArr[counter % 2];
                }
            }
        }
        if (myArr[counter % 2].equals("X")){
            player = 1;
        }
        else {
            player = 2;
        }

        counter++;
        if (9 == counter) {
            winner = 3;
        }
        else {
            CheckMove checkMove = new CheckMove();
            winner = checkMove.checking(board, player);
        }
        if ( 0 != winner ){
            Button result = (Button) findViewById(R.id.button_result);
            for (int i = 0; i < 10; i++){
                buttons[i].setClickable(false);
            }
            if (1 == winner){
                result.setText("Game Over! Player1 wins!");
            }
            else if (2 == winner){
                result.setText("Game Over! Player2 wins!");
            }
            else {
                result.setText("Game Over! Nobody wins, Press RESTART to go again");
            }
        }
    }
    public void restart (View view){
        onStart();
    }
}
