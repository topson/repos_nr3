package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 05.10.2015.
 */
public class CheckMove {

    protected int checking( String board [][], int player ) {
        int gameOver;
        int winner;

        CheckBot checkBot = new CheckBot();
        if (checkBot.checkRight(board) == 1 || checkBot.checkDown(board) == 1 || checkBot.checkDR(board) == 1 || checkBot.checkUR(board) == 1) {
            gameOver = 1;
        }
        else {
            gameOver = 0;
        }
        if ( 1 == gameOver && 1 == player){
            winner = 1;
        }
        else if ( 1 == gameOver && 2 == player){
            winner = 2;
        }
        else {
            winner = 0;
        }
        return winner;
    }
}
