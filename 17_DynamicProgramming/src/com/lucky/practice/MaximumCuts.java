package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumCuts {
    public static void main(String[] args) {
        System.out.println(maxCutsDP(23,12,11,13));
        System.out.println(maxCutsRec(23,12,11,13));
        System.out.println(maxCutsDP(5,1,2,3));
        System.out.println(maxCutsRec(5,1,2,3));
    }
    public static int maxCutsRec(int n,int a, int b, int c){
        if(n<0) return -1;
        if (n==0) return 0;
        int res = Math.max(maxCutsRec(n-a,a,b,c),Math.max(maxCutsRec(n-b,a,b,c),maxCutsRec(n-c,a,b,c)));
        if (res==-1) return -1;
        else return res+1;
    }

    //Time complexity: O(n)
    //Auxiliary space: O(n)
    public static int maxCutsDP(int n,int a,int b,int c) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if ((i - a) >= 0) dp[i] = Math.max(dp[i], dp[i - a]);
            if ((i - b) >= 0) dp[i] = Math.max(dp[i], dp[i - b]);
            if ((i - c) >= 0) dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1) dp[i]++;
        }
//        System.out.println(Arrays.stream(dp).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        return dp[n];
    }

}
