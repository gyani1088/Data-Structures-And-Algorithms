package com.lucky.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sudoku{
    public static void main(String[] args) {
        int N = 4;
        int[][] G = new int[][]{{1,0,3,0},{0,0,2,1},{0,1,0,2},{2,4,0,0}};
        printMatrix(G);
        System.out.println("===SOLVED===");
        System.out.println(solve(G,N));
    }

    private static boolean solve(int[][] G, int N) {
        int i=0,j=0;
        boolean rowFlag=false;
        for(i=0;i<N;i++){
            for(j=0;j<N;j++) {
                if (G[i][j] == 0) {
                    rowFlag=true;
                    break;
                }
            }
            if(rowFlag) break;
        }
        if(i==N && j==N){
            printMatrix(G);
            return true;
        }
        for(int x=1;x<=N;x++){
            if(isSafe(G,i,j,x)){
                G[i][j]=x;
                if(solve(G,N)) return true;
                G[i][j]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] G,int row, int col, int num) {
        for(int k=0;k<G.length;k++){
            if(G[k][col]==num || G[row][k]==num) return false;
        }
        int sq = (int) Math.sqrt(G.length);
        int rs = row-row%sq;
        int cs = col-col%sq;
        for(int i=0;i<sq;i++){
            for(int j=0;j<sq;j++){
                if(G[rs+i][cs+j]==num) return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(IntStream.range(0,matrix.length).mapToObj(
                rowNum -> IntStream.range(0,matrix.length).mapToObj(i-> {
                    return matrix[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }
}
