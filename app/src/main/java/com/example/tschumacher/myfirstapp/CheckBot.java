package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 06.10.2015.
 */

class CheckBot {
    int gameOver;

    protected int checkRight ( String board [][] ){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < 1; j++){
                if ( !board[i][j].equals("-")
                        && board[i][j].equals(board[i][j+1])
                        && board[i][j].equals(board[i][j+2]) ){
                    gameOver = 1;
                }
            }
        }
        return gameOver;
    }

    protected int checkDown( String board[][] ) {
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 3; j++){
                if ( !board[i][j].equals("-")
                        && board[i][j].equals(board[i+1][j])
                        && board[i][j].equals(board[i+2][j]) ){
                    gameOver = 1;
                }
            }
        }
        return gameOver;
    }

    protected int checkDR ( String board [][]){
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 1; j++){
                if ( !board[i][j].equals("-")
                        && board[i][j].equals(board[i+1][j+1])
                        && board[i][j].equals(board[i+2][j+2]) ){
                    gameOver = 1;
                }
            }
        }
        return gameOver;
    }

    protected int checkUR ( String board [][] ){
        for (int i = 2; i < 3; i++){
            for (int j = 0; j < 1; j++){
                if ( !board[i][j].equals("-")
                        && board[i][j].equals(board[i - 1][j + 1])
                        && board[i][j].equals(board[i - 2][j + 2])) {
                    gameOver = 1;
                }
            }
        }
        return gameOver;
    }
}
