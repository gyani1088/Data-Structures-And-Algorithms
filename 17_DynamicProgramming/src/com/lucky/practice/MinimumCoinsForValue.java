package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinimumCoinsForValue {
    public static void main(String[] args) {
        int[] coins = {25,10,5};
        System.out.println(getMin(coins,30));
        System.out.println(getMin_DP(coins,30));
    }
    public static int getMin(int[] coins, int val){
        if(val==0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=val){
                int subRes = getMin(coins,val-coins[i]);
                if (subRes!=Integer.MAX_VALUE) res = Math.min(res,subRes+1);
            }
        }
        return res;
    }

    //Time complexity:Theta(n*val)
    //Aux space:Theta(val)
    public static int getMin_DP(int[] coins,int val){
        int n = coins.length;
        int[] dp = new int[val+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=val;i++){
            for(int j=0;j<n;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        System.out.println(Arrays.stream(dp).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        return dp[val];
    }
}
