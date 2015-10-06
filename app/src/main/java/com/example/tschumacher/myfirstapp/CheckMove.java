package com.example.tschumacher.myfirstapp;

/**
 * Created by t.schumacher on 05.10.2015.
 */
public class CheckMove {

    protected int checkRight ( int column ){
        int rightIndex = column + 1;
        return rightIndex;
    }
    protected int checkDown( int row ){
        int downIndex = row + 1;
        return downIndex;
    }
    protected int checkLeft ( int column ){
        int leftColumn = column - 1;
        return leftColumn;
    }
    protected int checkUp ( int row ){
        int upRow = row - 1;
        return upRow;
    }
    protected int checking( String board [][], int player ){

        int k;
        int m;
        int gameOver = 0;
        int winner;
        for ( int i = 0; i < 3; i++ ){
            for ( int j = 0; j < 3; j++ ) {
                if (!board[i][j].equals("-")) {
                    if (0 == i && 0 == j) {
                        if (board[i][j].equals(board[checkDown(i)][checkRight(j)])) {
                            k = checkDown(i);
                            m = checkRight(j);
                            if (board[k][m].equals(board[checkDown(k)][checkRight(m)])) {
                                gameOver = 1;
                            }
                        }
                        else if (board[i][j].equals(board[checkDown(i)][j]) ){
                            k = checkDown(i);
                            if (board[k][j].equals(board[checkDown(k)][j]) ){
                                gameOver = 1;
                            }
                        }
                        else if (board[i][j].equals(board[i][checkRight(j)]) ){
                            k = checkRight(j);
                            if (board[i][k].equals(board[i][checkRight(k)]) ){
                                gameOver = 1;
                            }
                        }
                    }
                    else if (0 == j && 2 == i) {
                        if (board[i][j].equals(board[checkUp(i)][checkRight(j)])) {
                            k = checkUp(i);
                            m = checkRight(j);
                            if (board[k][m].equals(board[checkUp(k)][checkRight(m)])) {
                                gameOver = 1;
                            }
                        }
                        else if (board[i][j].equals(board[i][checkRight(j)]) ){
                            k = checkRight(j);
                            if (board[i][k].equals(board[i][checkRight(k)]) ){
                                gameOver = 1;
                            }
                        }
                    }
                    else if ( 0 == i ){
                        if (board[i][j].equals(board[checkDown(i)][j]) ){
                            k = checkDown(i);
                            if (board[k][j].equals(board[checkDown(k)][j]) ){
                                gameOver = 1;
                            }
                        }
                    }
                    else if ( 0 == j ){
                        if (board[i][j].equals(board[i][checkRight(j)]) ){
                            k = checkRight(j);
                            if (board[i][k].equals(board[i][checkRight(k)]) ){
                                gameOver = 1;
                            }
                        }
                    }
                }
            }
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
