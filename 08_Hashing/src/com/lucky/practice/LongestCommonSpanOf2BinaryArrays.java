package com.lucky.practice;

import java.util.HashMap;

public class LongestCommonSpanOf2BinaryArrays {
    public static void main(String[] args) {
        System.out.println(naiveMethod(new int[]{0,1,0,0,0,0},new int[]{1,0,1,0,0,1}));
        System.out.println(efficientMethod(new int[]{0,1,0,0,0,0},new int[]{1,0,1,0,0,1}));
    }

    //Time complexity: O(n2)
    //Aux Space: O(1)
    public static int naiveMethod(int[] arr1,int[] arr2){
        int max = 0;
        for(int i=0;i<arr1.length;i++){
            int sum1=0,sum2=0;
            for(int j=i;j<arr1.length;j++){
                sum1+=arr1[j];
                sum2+=arr2[j];
                if(sum1==sum2) max = Math.max(max,j-(i-1));
            }
        }
        return max;
    }

    //Time complexity: O(n)
    //Aux space: O(n)+O(n)
    public static int efficientMethod(int[] arr1, int[] arr2){
        int max=0;
        //diff array will have the differences of the values of arr1 and arr2 at a given index
        int[] diff = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            diff[i]=arr1[i]-arr2[i];
        }
        //longest subarray with given sum where sum=0
        int cumulative = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<diff.length;i++){
            cumulative+=diff[i];
            if(cumulative==0) max=i+1;
            map.putIfAbsent(cumulative,i);
            if(map.containsKey(cumulative)) max = Math.max(max,i-map.get(cumulative));
        }
        return max;
    }

}

//0,1,0,0,0,0
//1,0,1,0,0,1
//diff: -1,1,-1,0,0,-1
//cumsum: -1,0,-1,-1,-1,-2
//                  (4-0)