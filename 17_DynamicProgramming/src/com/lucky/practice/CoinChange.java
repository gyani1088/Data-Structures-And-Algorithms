package com.lucky.practice;

/**
 * Infinitely many coins of each type is provided.
 * */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(countWays(coins,4,coins.length));
        System.out.println(countWays_DP(coins,4,coins.length));
    }
    //Naive recursion
    public static int countWays(int coins[], int s, int n){
        if(s==0) return 1;
        else if (s<0) return 0;
        if (n==0) return 0;
        //n*s times (same as convolution)
        return countWays(coins,s-coins[n-1],n) + countWays(coins,s,n-1);
    }

    //DP way (Tabulation)
    //Time complexity:O(ns)
    public static int countWays_DP(int coins[],int s,int n){
        int[][] dp = new int[n+1][s+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }
        for (int j=1;j<=s;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=s;j++){
                dp[i][j]=dp[i-1][j];
                if(coins[i-1]<=j){
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][s];
    }
}
