package com.example.tschumacher.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ShowScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
    }

    protected void onStart( ){
        super.onStart();
        for ( int i = R.id.playerOneScore; i <= R.id.drawScore; i++){
            switch ( i ){
                case R.id.playerOneScore:
                    TextView playerOneScore = (TextView) findViewById(R.id.playerOneScore);
                    playerOneScore.setText("" + TickTackToe.score[0]);
                    break;
                case R.id.playerTwoScore:
                    TextView playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
                    playerTwoScore.setText("" + TickTackToe.score[1]);
                    break;
                case R.id.drawScore:
                    TextView drawScore = (TextView) findViewById(R.id.drawScore);
                    drawScore.setText("" + TickTackToe.score[2]);
                    break;
                default:
                    break;
            }
        }
    }
    public void goBack( View view ){
        Intent intent = new Intent(this, TickTackToe.class);
        startActivity(intent);
    }

}
