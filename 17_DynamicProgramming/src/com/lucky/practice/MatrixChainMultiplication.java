package com.lucky.practice;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arr[] ={2,1,3,4};
        System.out.println(mulCount(arr,0,arr.length-1));
        System.out.println(mChain_DP(arr));
    }
    public static int mulCount(int[] arr, int i,int j){
        if(i==j-1) return 0;
        int res = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            res = Math.min(res,mulCount(arr,i,k)+
                    mulCount(arr,k,j)+
                    arr[i]*arr[k]*arr[j]);
        }
        return res;
    }

    public static int mChain_DP(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=0;
        }
        for(int gap = 2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j= i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
