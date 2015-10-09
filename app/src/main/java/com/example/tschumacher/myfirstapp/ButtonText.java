package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 08.10.2015.
 */

class ButtonText extends TickTackToe {
    public enum Player{
        PLAYER1, PLAYER2
    }

    Player plyr;

    int player;

    public Player getPlyr(Player plyr){
        this.plyr = plyr;
        if ( myArr[counter % 2].equals("X")){
            plyr = Player.PLAYER1;
        }
        else {
            plyr = Player.PLAYER2;
        }
        return plyr;
    }

    protected void clickMe (){
        /*if ( myArr[counter % 2].equals("X") ) {
            player = 1;
        } else {
            player = 2;
        }*/
        plyr = getPlyr(plyr);
        if ( plyr == Player.PLAYER1 ){
            player = 1;
        }
        else {
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
