package com.lucky.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int array[] ={80,55,15,40,50,100,25,45};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println(kLargest(array,4));
        System.out.println(kLargestEfficient(array,4));
    }

    //Time complexity:O(n) + O(klogn)
    public static List<Integer> kLargest(int[] array, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<array.length;i++){
            pq.add(array[i]);
        }
        List<Integer> kMax = new ArrayList<>();
        while(k>0){
            kMax.add(pq.poll());
            k--;
        }
        return kMax;
    }

    //Efficient Solution : Using a minHeap
    // Time complexity: O(k+nlogK)
    public static List<Integer> kLargestEfficient(int[] array,int k){
        //Build a min heap of k elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(array[i]);
        }
        List<Integer> kMax = new ArrayList<>();
        //At any point you'll have k largest elements you've seen so far
        for(int i=k;i<array.length;i++){
            if(pq.peek()>array[i]) continue;
            else {
                pq.poll();
                pq.add(array[i]);
            }
        }
        while(k>0){
            kMax.add(pq.poll());
            k--;
        }
        return kMax;
    }
}
