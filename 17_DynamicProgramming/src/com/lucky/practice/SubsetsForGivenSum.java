package com.lucky.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsetsForGivenSum {

    public static void main(String[] args) {
        int[] arr = {307,781,523,494,950,899,387,329,977,510,388,203,627,139,959,650,459,669,182,147,429,721,175,659,15,415,63,740,657,555,736,316,335,258,161,636,508,547,965,484,56,704,38,34,843};
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
        if(sum%2==0) {
            System.out.println(countSubsetsWithSum(arr, arr.length, sum/2));
            System.out.println(countSubsetsWithSum(arr, sum/2));
        }
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
        for(int i=0;i<=sum;i++){
            dp[0][i] = 0;
        }
        dp[0][0]=1;
        int countZero=0;
        for(int i=1;i<=n;i++){
             if(arr[i-1]==0) countZero++;
             dp[i][0] = (int) Math.pow(2,countZero);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) dp[i][j]=dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];
            }
        }
        System.out.println(IntStream.range(0,n+1).mapToObj(
                rowNum -> IntStream.range(0,sum+1).mapToObj(i-> {
                    return dp[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        return dp[n][sum];
    }
}