package com.lucky.practice;

import java.util.Arrays;

public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,2,1};
        System.out.println(minJumps_DP(arr));
        System.out.println(minJumps_Rec(arr,arr.length));
        arr = new int[]{4,1,5,3,1,3,2,1,8};
        System.out.println(minJumps_DP(arr));
        System.out.println(minJumps_Rec(arr,arr.length));
    }
    public static int minJumps_Rec(int[] arr,int n){
        if(n==1) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(i+arr[i]>=n-1){
                int subRes = minJumps_Rec(arr,i+1);
                if(subRes!=Integer.MAX_VALUE) res = Math.min(res,subRes+1);
            }
        }
        return res;
    }

    //Time complexity: Theta(n)
    //Aux space: O(n)
    public static int minJumps_DP(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]+j>=i){
                    if(dp[j]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
}
