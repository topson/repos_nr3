package com.example.tschumacher.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TickTackToe extends AppCompatActivity {
    static int [] score = {0, 0, 0};
    static int gameCount = 0;
    static int counter;
    static int winner;
    static String[][] board = new String[3][3];
    static Button[] buttons = new Button[12];
    int[] index = new int[12];
    static String[] myArr = {"X", "O"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_tack_toe);
    }

    protected void onStart() {
        super.onStart();
        gameCount++;
        for (int k = 0; k < 3; k++) {
            for (int m = 0; m < 3; m++) {
                board[k][m] = "-";
            }
        }
        winner = 0;
        counter = 0;
        int j = 0;
        for (int i = R.id.button1; i <= R.id.score_button; i++) {
            index[j] = i;
            j++;
        }
        for (int i = 0; i < 12; i++) {
            Drawable background = findViewById(R.id.restart).getBackground();
            /*if (9 == i) {
                buttons[i] = (Button) findViewById(index[i]);
                buttons[i].setText(R.string.result);
            } else {
                buttons[i] = (Button) findViewById(index[i]);
                buttons[i].setText("-");
                buttons[i].setClickable(true);
                buttons[i].setBackgroundColor(Color.LTGRAY);
                buttons[i].setBackground(background);
            }*/
            switch (i) {
                case 11:
                    buttons[i] = (Button) findViewById(index[i]);
                    buttons[i].setText(R.string.scoreBtn);
                    break;
                case 10:
                    break;
                case 9:
                    buttons[i] = (Button) findViewById(index[i]);
                    buttons[i].setText(R.string.result);
                    break;
                default:
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

    public void click(View view) {

        if (view instanceof Button) {
            Button button = (Button) view;
            button.setText(myArr[counter % 2]);
            if ( myArr[counter % 2].equals("X") ) {
                button.setBackgroundColor(Color.CYAN);
            } else {
                button.setBackgroundColor(Color.RED);
            }
            button.setClickable(false);
            for (int k = 0; k < 9; k++){
                if (buttons[k] == button){
                    board[Math.abs(k / 3)][k % 3] = myArr[counter % 2];
                }
            }
        }
        ButtonText buttonText = new ButtonText();
        buttonText.clickMe();

        if ( 0 != winner ) {
            Button result = (Button) findViewById(R.id.button_result);
            for (int i = 0; i < 10; i++) {
                buttons[i].setClickable(false);
            }
            if (1 == winner) {
                result.setText(R.string.winner1);
                score[0]++;
            } else if (2 == winner) {
                result.setText(R.string.winner2);
                score[1]++;
            } else {
                result.setText(R.string.winner3);
                score[2]++;
            }

        }
    }

    public void restart ( View view ) {
        onStart();
    }

    public void showScore (View view) {
        //Button button = (Button) findViewById(R.id.score_button);
        //button.setText("player1 score: " +score[0]);
        Intent intent = new Intent(this, ShowScore.class);
        startActivity(intent);
    }

}
