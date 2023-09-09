package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MemoizationExample {

    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println(fibonacci(n,memo));
        System.out.println(Arrays.stream(memo).mapToObj(val->val+"").collect(Collectors.joining(" ")));
    }
    public static int fibonacci(int n, int[] memo){
        if(memo[n]==-1){
            int res = 0;
            if (n==0 || n==1) res = n;
            else res = fibonacci(n-1,memo)+fibonacci(n-2,memo);
            memo[n]= res;
        }
        return memo[n];
    }
}
