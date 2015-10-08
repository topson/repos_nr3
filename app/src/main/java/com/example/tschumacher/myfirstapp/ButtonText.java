package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 08.10.2015.
 */

class ButtonText extends TickTackToe {
    int player;

    protected void clickMe (){

        if ( myArr[counter % 2].equals("X") ) {
            player = 1;
        } else {
            player = 2;
        }
        counter++;
        if (9 == counter) {
            winner = 3;
        } else {
            CheckMove checkMove = new CheckMove();
            winner = checkMove.checking(board, player);
        }
    }
}
