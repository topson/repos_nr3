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
        int winner;
        /*int[] index = new int[9];
        int j = 0;

        for (int i = 2131492944; i < 2131492953; i++){
            index[j] = i;
            j++;
        } */

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

            /*
            int the_button = button.getId();
            button.setText(myArr[counter % 2]);
            for (int k = 0; k < 9; k++){
                if (index[k] == the_button){
                    board[k] = (myArr[counter % 2]);
                }
            }
            button.setBackgroundColor(Color.CYAN);
            button.setClickable(false); */

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



        /*
        if (1 == counter % 2) {
            if (null != board[4] && myArr[0].equals(board[4])) {
                if ((null != board[0]) && myArr[0].equals(board[0]) && (null != board[8]) && myArr[0].equals(board[8])) {
                    gameOver = 1;
                }
                else if (null != board[6] && board[6].equals(myArr[0]) && null != board[6] && board[2].equals(myArr[0])) {
                    gameOver = 1;
                }
                else if (null != board[1] && board[1].equals(myArr[0]) && null != board[7] && board[7].equals(myArr[0])) {
                    gameOver = 1;
                }
                else if (null != board[3] && board[3].equals(myArr[0]) && null != board[5] && board[5].equals(myArr[0])) {
                    gameOver = 1;
                }
            }
            else if (null != board[0] && board[0].equals(myArr[0])) {
                if (null != board[3] && board[3].equals(myArr[0]) && null != board[6] && board[6].equals(myArr[0])) {
                    gameOver = 1;
                }
                else if (null != board[1] && board[1].equals(myArr[0]) && null != board[2] && board[2].equals(myArr[0])) {
                    gameOver = 1;
                }
            }
            else if (null != board[8] && board[8].equals(myArr[0])) {
                if (null != board[6] && board[6].equals(myArr[0]) && null != board[7] && board[7].equals(myArr[0])) {
                    gameOver = 1;
                }
                else if (null != board[5] && board[5].equals(myArr[0]) && null != board[2] && board[2].equals(myArr[0])) {
                    gameOver = 1;
                }
            }
        }
        else {
            if (null != board[4] && myArr[1].equals(board[4])) {
                if ((null != board[0]) && myArr[1].equals(board[0]) && (null != board[8]) && myArr[1].equals(board[8])) {
                    gameOver = 2;
                }
                else if (null != board[6] && board[6].equals(myArr[1]) && null != board[6] && board[2].equals(myArr[1])) {
                    gameOver = 2;
                }
                else if (null != board[1] && board[1].equals(myArr[1]) && null != board[7] && board[7].equals(myArr[1])) {
                    gameOver = 2;
                }
                else if (null != board[3] && board[3].equals(myArr[1]) && null != board[5] && board[5].equals(myArr[1])) {
                    gameOver = 2;
                }
            }
            else if (null != board[0] && board[0].equals(myArr[1])) {
                if (null != board[3] && board[3].equals(myArr[1]) && null != board[6] && board[6].equals(myArr[1])) {
                    gameOver = 2;
                }
                else if (null != board[1] && board[1].equals(myArr[1]) && null != board[2] && board[2].equals(myArr[1])) {
                    gameOver = 2;
                }
            }
            else if (null != board[8] && board[8].equals(myArr[1])) {
                if (null != board[6] && board[6].equals(myArr[1]) && null != board[7] && board[7].equals(myArr[1])) {
                    gameOver = 2;
                }
                else if (null != board[5] && board[5].equals(myArr[1]) && null != board[2] && board[2].equals(myArr[1])) {
                    gameOver = 2;
                }
            }
        } */
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

        /*Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("-");
        button1.setClickable(true);
        button1.setBackgroundColor(Color.LTGRAY);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("-");
        button2.setClickable(true);
        button2.setBackgroundColor(Color.LTGRAY);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("-");
        button3.setClickable(true);
        button3.setBackgroundColor(Color.LTGRAY);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("-");
        button4.setClickable(true);
        button4.setBackgroundColor(Color.LTGRAY);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText("-");
        button5.setClickable(true);
        button5.setBackgroundColor(Color.LTGRAY);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText("-");
        button6.setClickable(true);
        button6.setBackgroundColor(Color.LTGRAY);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText("-");
        button7.setClickable(true);
        button7.setBackgroundColor(Color.LTGRAY);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setText("-");
        button8.setClickable(true);
        button8.setBackgroundColor(Color.LTGRAY);
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setText("-");
        button9.setClickable(true);
        button9.setBackgroundColor(Color.LTGRAY);
        Button result = (Button) findViewById(R.id.button_result);
        result.setText("Result");
        result.setClickable(true);
        result.setBackgroundColor(Color.LTGRAY);
        counter = 0;
        for (int i = 0; i < 9; i++){
            board[i] = "-";
        } */
        onStart();
    }
}
