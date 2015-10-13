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
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }
    protected void onStart(){
        super.onStart();
        TickTackToe ttt = new TickTackToe();
        for ( int i = R.id.playerOne; i <= R.id.noWinner; i++){
            switch ( i ){
                case R.id.playerOne:
                    TextView playerNrOne = (TextView) findViewById(R.id.playerOne);
                    playerNrOne.setText("Player1:     " + ttt.score[0]);
                    break;
                case R.id.playerTwo:
                    TextView playerDeux = (TextView) findViewById(R.id.playerTwo);
                    playerDeux.setText("Player2:     " + ttt.score[1]);
                    break;
                case R.id.noWinner:
                    TextView deuce = (TextView) findViewById(R.id.noWinner);
                    deuce.setText("Draw:        " + ttt.score[2]);
                    break;
            }
        }
    }
    public void goBack( View view ){
        Intent intent = new Intent(this, TickTackToe.class);
        startActivity(intent);
    }

}
