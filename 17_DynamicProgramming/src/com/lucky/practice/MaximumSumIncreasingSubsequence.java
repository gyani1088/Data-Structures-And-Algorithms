package com.lucky.practice;

/**
 * A variation of longest increasing subsequence
 * */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3,20,4,6,7,30};
        System.out.println(maxSumIncSubseq(arr));
    }

    //DP method and not binary search
    public static int maxSumIncSubseq(int[] arr){
        int n = arr.length;
        int msis[] = new int[n];
        int maxSum = arr[0];
        for(int i=0;i<n;i++){
            msis[i]=arr[i];
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]) msis[i]=Math.max(msis[i],msis[j]+arr[i]);
            }
            maxSum = Math.max(maxSum,msis[i]);
        }
        return maxSum;
    }
}
