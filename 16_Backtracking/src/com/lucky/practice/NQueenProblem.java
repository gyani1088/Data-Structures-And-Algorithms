package com.lucky.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NQueenProblem {
    public static void main(String[] args) {
        int N =8;
        boolean[][] board = new boolean[N][N];
        System.out.println(solve(board));
    }

    private static boolean solve(boolean[][] board) {
        if(solveRec(board,0)==false) return false;
        else{
            printBoard(board);
            return true;
        }
    }

    private static void printBoard(boolean[][] board) {
        System.out.println(IntStream.range(0,board.length).mapToObj(
                rowNum -> IntStream.range(0,board.length).mapToObj(i-> {
                    return board[rowNum][i]?1+"":0+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }

    private static boolean solveRec(boolean[][] board, int col) {
        if(col==board.length) return true;
        for(int i=0;i<board.length;i++){
            if(isSafe(board,i,col)){
                board[i][col] = true;
                if(solveRec(board,col+1)==true) return true;
                board[i][col] = false;
            }
        }
        return false;
    }

    private static boolean isSafe(boolean[][] board,int row, int col) {
        //if another queen is present in the same row before the current column
        for(int i=0;i<col;i++){
            if(board[row][i]) return false;
        }
        //if another queen is present in the upper left diagonal before the current row and column
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]) return false;
        }
        //if another queen is present in the lower left diagonal before the current column and after the current row
        for(int i=row,j=col;i<board.length && j>=0 ;i++,j--){
            if(board[i][j]) return false;
        }
        return true;
    }

}
