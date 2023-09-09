package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountBST_withNkeys {
    public static void main(String[] args) {
        System.out.println(countBST(5));
        System.out.println(countBST_DP(5));
        System.out.println(countBST_Catalan(5));
    }

    //Sum of(countBST on the LHS * countBST on the RHS)
    public static int countBST(int n){
        if(n==0) return 1;
        int res = 0;
        for(int i = 0;i<n; i++){
            res+=countBST(i)*countBST(n-i-1);
        }
        return res;
    }

    //Time complexity: O(n2)
    //Aux space: O(n)
    public static int countBST_DP(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    //Most efficient way using the formula of catalan numbers
    public static int countBST_Catalan(int n){
        int[] factorials = factorialsUpto2n(n);
//        System.out.println(Arrays.stream(factorials).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        return ((factorials[2*n]/factorials[n+1])/factorials[n]);
    }
    private static int[] factorialsUpto2n(int n){
        int dp[] = new int[2*n+1];
        dp[0]=1;
        for(int i=1;i<=2*n;i++){
            dp[i]=i*dp[i-1];
        }
        return dp;
    }
}
