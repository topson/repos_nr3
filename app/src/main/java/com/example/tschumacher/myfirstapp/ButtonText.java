package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 08.10.2015.
 */

class ButtonText extends TickTackToe {
    int player;

    protected void clickMe (){
        if ( 0 == counter % 2 ) {
            player = 1;
        } else {
            player = 2;
        }

        counter++;
        if (9 == counter) {
            CheckMove checkMove = new CheckMove();
            if (0 == checkMove.checking(board, player)) {
                winner = 3;
            } else {
                winner = checkMove.checking(board, player);
            }
        }
    }
}
