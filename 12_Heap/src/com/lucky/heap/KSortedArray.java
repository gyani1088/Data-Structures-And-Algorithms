package com.lucky.heap;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {9,8,7,19,18};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sort(arr,2);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
    //k-> range to the left and right of the current element, where these can go
    //Time complexity with normal best sorting algorithm: O(nlogn)
    //Time complexity : O(n+klogk)
    public static void sort(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<=k;i++)
            pq.add(arr[i]);
        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()) arr[index++]=pq.poll();
    }
}
