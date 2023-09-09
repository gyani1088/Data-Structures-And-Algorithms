package com.lucky.practice;

public class SubsetsForGivenSum {

    public static void main(String[] args) {
        int[] arr = {10,5,2,3,6};
        System.out.println(countSubsetsWithSum(arr,arr.length,8));
        System.out.println(countSubsetsWithSum(arr,8));
    }
    public static int countSubsetsWithSum(int[] arr, int n, int sum){
        if(n==0) return (sum==0)?1:0;
        return countSubsetsWithSum(arr,n-1,sum)+countSubsetsWithSum(arr,n-1,sum-arr[n-1]);
    }

    //Time complexity: O(n X sum)
    //Aux space: O(n X sum)
    public static int countSubsetsWithSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=sum;i++){
            dp[0][sum] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) dp[i][j]=dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];
            }
        }
        return dp[n][sum];
    }
}