package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 05.10.2015.
 */
public class CheckMove {

    protected int checkRight ( int column ){
        int rightIndex = column++;
        return rightIndex;
    }
    protected int checkDown(int row){
        int downIndex = row++;
        return downIndex;
    }
    protected int checkLeft ( int column){
        int leftColumn = column--;
        return leftColumn;
    }
    private int checking( String board [][], int player){
        int k;
        int m;
        int gameOver = 0;
        int winner = 0;
        for ( int i = 0; i < 3; i++ ){
            for ( int j = 0; j < 3; j++ ){
                if ( 0 == i ) {
                    if ( board[i][j].equals(board[checkDown(i)][j]) ){
                        k = checkDown(i);
                        if ( board[k][j].equals(board[checkDown(k)][j]) ){
                            gameOver = 1;
                        }
                    }
                }
                if (0 == j) {
                    if ( board[i][j].equals(board[i][checkRight(j)]) ) {
                        k = checkRight(j);
                        if ( board[i][k].equals(board[i][checkRight(k)]) ) {
                            gameOver = 1;
                        }
                    }
                }
                if ( 0 == i && 0 == j){
                    if ( board[i][j].equals(board[checkDown(i)][checkRight(j)]) ){
                        k = checkDown(i);
                        m = checkRight(j);
                        if ( board[k][m].equals(board[checkDown(k)][checkRight(m)]) ){
                            gameOver = 1;
                        }
                    }
                }
                if ( 2 == i && 0 == j){
                    if ( board[i][j].equals(board[checkDown(i)][checkRight(j)]) ){
                        k = checkDown(i);
                        m = checkRight(j);
                        if ( board[k][m].equals(board[checkDown(k)][checkRight(m)]) ){
                            gameOver = 1;
                        }
                    }
                }
            }
        }
        if ( 1 == gameOver && 1 == player){
            winner = 1;
        }
        else {
            winner  = 2;
        }
        return winner;
    }
}
