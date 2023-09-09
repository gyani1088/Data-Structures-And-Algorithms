package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxSumNoConsecutives {
    public static void main(String[] args) {
        int[] arr = {10,5,15,20};
        System.out.println(maxSumWithNoConsecutive(arr,arr.length));
        System.out.println(maxSumWithNoConsecutive(arr));
    }
    public static int maxSumWithNoConsecutive(int[] arr, int n){
        if(n==1) return arr[0];
        else if(n==2) return Math.max(arr[0],arr[1]);
        else{
            return Math.max(maxSumWithNoConsecutive(arr,n-1),maxSumWithNoConsecutive(arr,n-2)+arr[n-1]);
        }
    }

    //Time complexity: O(n)
    //Auxiliary space:O(n)
    public static int maxSumWithNoConsecutive(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i==1) dp[1] = arr[0];
            else if(i==2) dp[2] = Math.max(arr[0],arr[1]);
            else dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i-1]);
        }
        System.out.println(Arrays.stream(dp).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        return dp[n];
    }

    //Space optimized
    public static int maxSumWithNoConsecutive_SpaceOptimized(int[] arr){
        int n = arr.length;
        if(n==1) return arr[0];
        int prev_prev=arr[0];
        int prev=Math.max(arr[0],arr[1]);
        int res=prev;
        for(int i=3;i<=n;i++){
            res = Math.max(prev,prev_prev+arr[i-1]);
            prev_prev = prev;
            prev = res;
        }
        return res;
    }
}
