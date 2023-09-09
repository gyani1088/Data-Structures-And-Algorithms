package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Knapsack0_1 {
    public static void main(String[] args) {
        int[] val = {10,40,30,50};
        int[] weight = {5,4,6,3};
        int W = 10;
        System.out.println(knapsack(W,weight,val,val.length));
        System.out.println(knapsack(W,weight,val));

    }
    //Time complexity: O(2^n)
    public static int knapsack(int W, int[] weight, int[] val, int n){
        if(n==0 || W==0) return 0;
        if(weight[n-1]>W)
            return knapsack(W,weight,val,n-1);
        else
            return Math.max(knapsack(W,weight,val,n-1), val[n-1]+knapsack(W-weight[n-1],weight,val,n-1));
    }

    //Dynamic Programming
    //Time complexity :O(nW)  but W can be large and it'll look like a pseudo-polynomial time
    public static int knapsack(int W,int[] weight,int[] val){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(weight[i-1]>j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(val[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
            }
        }
        System.out.println(IntStream.range(0,n+1).mapToObj(
                rowNum -> IntStream.range(0,W+1).mapToObj(col-> {
                    return dp[rowNum][col]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        return dp[n][W];
    }
}
