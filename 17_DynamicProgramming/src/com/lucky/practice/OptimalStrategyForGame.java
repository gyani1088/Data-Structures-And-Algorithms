package com.lucky.practice;

/**
 * We need to maximize the sum provided the opponent is also playing with the most optimal strategy. Number of elements
 * is always even.
 * */
public class OptimalStrategyForGame {
    public static void main(String[] args) {
        int[] arr = {20,5,4,6};
        System.out.println(mainSolution(arr));
        System.out.println(solutionRec(arr,0,arr.length-1));
        System.out.println(solution_DP(arr));
    }
    public static int maxSum(int[] arr,int i,int j,int sum){
        if(j==i+1) return Math.max(arr[i],arr[j]);
        return Math.max(sum-maxSum(arr,i+1,j,sum-arr[i]),sum-maxSum(arr,i,j-1,sum-arr[j]));
    }
    public static int mainSolution(int arr[]){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return maxSum(arr,0,arr.length-1,sum);
    }

    public static int solutionRec(int[] arr, int i, int j){
        if(j==i+1) return Math.max(arr[i],arr[j]);
        return Math.max(arr[i]+Math.min(solutionRec(arr,i+2,j),solutionRec(arr,i+1,j-1)),
                arr[j]+Math.min(solutionRec(arr,i,j-2),solutionRec(arr,i+1,j-1)));
    }

    public static int solution_DP(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=Math.max(arr[i],arr[i+1]);
        }
        for(int gap=3;gap<n;gap+=2){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=Math.max(arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),
                        arr[j]+Math.min(dp[i][j-2],dp[i+1][j-1]));
            }
        }
        return dp[0][n-1];
    }
}
