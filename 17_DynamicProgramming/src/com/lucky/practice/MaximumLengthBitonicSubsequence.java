package com.lucky.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Bitonic - first increasing and then decreasing
 * */
public class MaximumLengthBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,11,2,10,4,5,2,1};
        System.out.println(maxLengthBitonicSubseq(arr));
    }

    //Time complexity: O(n2)
    //Aux space: Theta(n)
    public static int maxLengthBitonicSubseq(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        int[] lisRev = new int[n];
        for(int i=0;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) lis[i]=Math.max(1+lis[j],lis[i]);
            }
        }
        System.out.println("lis= " + Arrays.stream(lis).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        //for reverse
        for(int i=n-1;i>=0;i--){
            lisRev[i]=1;
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]) lisRev[i]=Math.max(1+lisRev[j],lisRev[i]);
            }
        }
        System.out.println("lisRev= "+Arrays.stream(lisRev).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        int max = 0;
        for(int i=0;i<n;i++){
            max=Math.max(max,lis[i]+lisRev[i]-1);
        }
        return max;
    }
}
