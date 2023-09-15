package com.lucky.practice;

/**
 * Similar to segment tree but NOT all operations for range queries are possible through Binary Indexed trees
 * */
public class BinaryIndexedTree {
    private static int N = 10;
    private static int[] arr = new int[N];
    private static int[] bITree = new int[N+1];

    public static void main(String[] args) {

    }
    //Construction of binary indexed tree
    //we make use of the update binary indexed tree method
    //Time complexity:O(N logN)
    public static void constructBITree(){
        for(int i=1;i<N+1;i++){
            bITree[i]=0;
        }
        for(int i=0;i<N;i++){
            update(i,arr[i]);
        }
    }


    //sum from 0 to n
    public static int getCumulativeSum(int i){
        i++;
        int res =0;
        while(i>0){
            res+=bITree[i];
            i=i-i&(-i);
        }
        return res;
    }

    //Time complexity: O(logN)
    public static void update(int i, int newValue){
        int diff = newValue-arr[i];
        arr[i]+=diff;
        i=i+1;
        while(i<=N){
            bITree[i]+=diff;
            i=i+i&(-i);
        }
    }
}
