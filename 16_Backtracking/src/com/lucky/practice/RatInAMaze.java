package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RatInAMaze {

    public static void main(String[] args) {
        int N = 3;
        boolean[][] maze = new boolean[][]{{true,false,true},{true,true,false},{false,true,true}};
        boolean[][] sol = new boolean[N][N];
        System.out.println("++MAZE-1++");
        System.out.println(IntStream.range(0,maze.length).mapToObj(
                rowNum -> IntStream.range(0,maze.length).mapToObj(i-> {
                    return maze[rowNum][i]?1+"":0+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println("========SOL=========");
        System.out.println(solveMaze(maze,sol));

        System.out.println("++MAZE-2++");
        N = 4;
        boolean[][] maze1 = new boolean[][]{{true,false,false,true},{true,true,true,false},{true,false,true,false},{false,false,true,true}};
        boolean[][] sol2 = new boolean[N][N];
        System.out.println(IntStream.range(0,maze1.length).mapToObj(
                rowNum2 -> IntStream.range(0,maze1.length).mapToObj(i-> {
                    return maze1[rowNum2][i]?1+"":0+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println("========SOL=========");
        System.out.println(solveMaze(maze1,sol2));
    }

    private static boolean solveMaze(boolean[][] maze, boolean[][] sol) {
        if(solveMazeRec(maze,sol,0,0, maze.length)==false) return false;
        else{
            printMatrix(sol);
            return true;
        }
    }

    private static boolean solveMazeRec(boolean[][] maze, boolean[][] sol, int i, int j,int N) {
        if (i==N-1 && j==N-1){
            sol[i][j]=true;
            return true;
        }
        if(isSafe(maze,i,j,N)==true){
            sol[i][j]=true;
            if (solveMazeRec(maze,sol,i+1,j,N)==true) return true;
            else if (solveMazeRec(maze,sol,i,j+1,N)==true) return true;
            sol[i][j]=false;
        }
        return false;
    }

    private static boolean isSafe(boolean[][] maze, int i, int j,int N) {
        return i<N && j<N && maze[i][j]==true;
    }

    private static void printMatrix(boolean[][] sol) {
        System.out.println(IntStream.range(0,sol.length).mapToObj(
                rowNum -> IntStream.range(0,sol.length).mapToObj(i-> {
                    return sol[rowNum][i]?1+"":0+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }

}
