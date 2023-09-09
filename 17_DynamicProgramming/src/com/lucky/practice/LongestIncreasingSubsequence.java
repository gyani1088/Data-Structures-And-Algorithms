package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3,4,2,8,10,5,1};
        System.out.println(LIS_DP(arr,arr.length));
        System.out.println(LIS_BinarySearch(arr));
    }

    //Time complexity: O(n2)
    //Aux space: O(n)
    public static int LIS_DP(int[] arr,int n){
        int[] lis = new int[n];
        lis[0]=1;
        int max = 1;
        for(int i=1;i<n;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) lis[i]=Math.max(lis[i],lis[j]+1);
            }
            max=Math.max(lis[i],max);
        }

        System.out.println(Arrays.stream(lis).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        return max;
    }

    //Time complexity:O(n logn)
    //Aux space: O(n)
    public static int LIS_BinarySearch(int[] arr){
        int n = arr.length;
        List<Integer> tail = new ArrayList<>();
        tail.add(arr[0]);
        int len = 1;
        for(int i=1;i<n;i++){
            if(arr[i]>tail.get(len-1)){
                tail.add(arr[i]);
                len++;
            }
            else{
                findCeilAndReplace(tail,arr[i]);
            }
        }
        System.out.println(tail);
        return tail.size();
    }

    private static void findCeilAndReplace(List<Integer> tail, int x) {
        int l=0;int r=tail.size()-1;
        while(r>l){
            int m = l+((r-l)/2);
            if(tail.get(m)>=x) r=m;
            else l=m+1;
        }
        tail.set(r,x);
    }
}
