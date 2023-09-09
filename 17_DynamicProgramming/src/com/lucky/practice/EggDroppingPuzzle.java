package com.lucky.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        System.out.println(countDropsRec(10,2));
        System.out.println(countDropsDP(100,4));
    }
    public static int countDropsRec(int floor, int eggs){
        if(eggs==1) return floor;
        if(floor==0) return 0;
        if(floor==1) return 1;
        int min = Integer.MAX_VALUE;
        int x,res;
        for(x=1;x<=floor;x++){
            res = Math.max(countDropsRec(x-1,eggs-1),countDropsRec(floor-x,eggs));
            min = Math.min(res,min);
        }
        return min+1;
    }

    //Time complexity: O(f^2*e)
    //Aux space: O(fxe)
    public static int countDropsDP(int floor, int eggs){
        int[][] dp = new int[floor+1][eggs+1];
        for(int i=1;i<=eggs;i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for(int i=1;i<=floor;i++){
            dp[i][1] = i;
        }
        for(int i=2;i<=floor;i++){
            for(int j=2;j<=eggs;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int x=1;x<=i;x++){
                    dp[i][j]=Math.min(dp[i][j],1+Math.max(dp[x-1][j-1],dp[i-x][j]));
                }
            }
        }
        System.out.println(IntStream.range(0,floor+1).mapToObj(
                rowNum -> IntStream.range(0,eggs+1).mapToObj(i-> {
                    return dp[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        return dp[floor][eggs];
    }

}
