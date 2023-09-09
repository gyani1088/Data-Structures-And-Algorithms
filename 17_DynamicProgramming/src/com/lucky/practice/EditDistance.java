package com.lucky.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EditDistance {
    public static void main(String[] args) {
        String s2 = "SATURDAY";
        String s1 = "SUNDAY";
        System.out.println(editDistanceRec(s1,s2,s1.length(),s2.length()));
        System.out.println(editDistance_DP(s1,s2,s1.length(),s2.length()));
        s1 = "SUN";
        s2 = "SON";
        System.out.println(editDistanceRec(s1,s2,s1.length(),s2.length()));
        System.out.println(editDistance_DP(s1,s2,s1.length(),s2.length()));
    }
    public static int editDistanceRec(String s1,String s2,int m,int n){
        if(m==0) return n;
        if(n==0) return m;
        if(s1.charAt(m-1)==s2.charAt(n-1)) return editDistanceRec(s1,s2,m-1,n-1);
        else return 1+Math.min(editDistanceRec(s1,s2,m-1,n-1),
                Math.min(editDistanceRec(s1,s2,m-1,n),editDistanceRec(s1,s2,m,n-1)));
    }

    public static int editDistance_DP(String s1,String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        System.out.println(IntStream.range(0,m+1).mapToObj(
                rowNum -> IntStream.range(0,n+1).mapToObj(i-> {
                    return dp[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        return dp[m][n];
    }
}
