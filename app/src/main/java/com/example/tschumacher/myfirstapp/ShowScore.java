package com.example.tschumacher.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ShowScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
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
    }
    protected void onStart(){
        super.onStart();
        TickTackToe ttt = new TickTackToe();
        for ( int i = R.id.player1; i <= R.id.draw; i++){
            switch ( i ){
                case R.id.player1:
                    TextView player1 = (TextView) findViewById(R.id.player1);
                    player1.setText("Player1:     "+ttt.score[0]);
                    break;
                case R.id.player2:
                    TextView player2 = (TextView) findViewById(R.id.player2);
                    player2.setText("Player2:     "+ttt.score[1]);
                    break;
                case R.id.draw:
                    TextView draw = (TextView) findViewById(R.id.draw);
                    draw.setText("Draw:        "+ttt.score[2]);
                    break;
            }
        }
    }
    public void goBack( View view ){
        Intent intent = new Intent(this, TickTackToe.class);
        startActivity(intent);
    }

}
