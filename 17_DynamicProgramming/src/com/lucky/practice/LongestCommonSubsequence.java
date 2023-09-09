package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABXCYZ";
        String s2 = "AXYYZ";
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];
        int[][] table = new int[m+1][n+1];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row,-1));
        System.out.println(IntStream.range(0,memo.length).mapToObj(
                rowNum -> IntStream.range(0,memo[rowNum].length).mapToObj(i-> {
                    return memo[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println(longestCommonSubsequence(s1,s2,m,n,memo));
        System.out.println(IntStream.range(0,memo.length).mapToObj(
                rowNum -> IntStream.range(0,memo[rowNum].length).mapToObj(i-> {
                    return memo[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println(longestCommonSubsequence(s1,s2,table));
        System.out.println(IntStream.range(0,table.length).mapToObj(
                rowNum -> IntStream.range(0,table[rowNum].length).mapToObj(i-> {
                    return table[rowNum][i]+"";
                }).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println(fetchLCS(s1,s2,table));
    }

    //Naive recursion
    public static int longestCommonSubsequence(String s1, String s2, int m, int n){
        if(m==0 || n==0) return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return 1+longestCommonSubsequence(s1,s2,m-1,n-1);
        else{
            return Math.max(longestCommonSubsequence(s1,s2,m-1,n),longestCommonSubsequence(s1,s2,m,n-1));
        }
    }

    //Memoization
    public static int longestCommonSubsequence(String s1, String s2, int m, int n,int[][] memo){
        //to check if we already have computed the solution
        if(memo[m][n]!=-1) return memo[m][n];
        else {
            if (m == 0 || n == 0) memo[m][n]=0;
            else{
                if (s1.charAt(m - 1) == s2.charAt(n - 1))
                    memo[m][n] = 1 + longestCommonSubsequence(s1, s2, m - 1, n - 1,memo);
                else {
                    memo[m][n] = Math.max(longestCommonSubsequence(s1, s2, m - 1, n,memo), longestCommonSubsequence(s1, s2, m, n - 1,memo));
                }
            }
            return memo[m][n];
        }
    }

    //Tabulation
    public static int longestCommonSubsequence(String s1, String s2, int[][] table){
        //to check if we already have computed the solution
        Arrays.fill(table[0],0);
        IntStream.range(0,s2.length()).forEach(i->table[0][i]=0);
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) table[i][j] = 1+table[i-1][j-1];
                else
                    table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
            }
        }
        return table[s1.length()][s2.length()];

    }

    public static String fetchLCS(String s1,String s2, int[][] table){
        StringBuilder s = new StringBuilder();
        int i= s1.length();
        for(int j=s2.length();j>=1;j--){
            if(table[i][j]==1+table[i][j-1]){
                s.insert(0,s2.charAt(j-1));
            }
        }
//        StringBuilder str = new StringBuilder();
//        int j= s2.length();
//        for(i=s1.length();i>=1;i--){
//            if(table[i][j]==1+table[i-1][j]){
//                str.insert(0,s1.charAt(i-1));
//            }
//        }
//        System.out.println(str);
        return s.toString();
    }
}
