package com.lucky.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {
    public static void main(String[] args) {
        int[] arr = {12,15,10,5,8,7,16};
        median(arr);
    }

    //Time complexity: O(n logn)
    public static void median(int[] arr){
        //Min heap
        PriorityQueue<Integer> greaterQueue = new PriorityQueue<>();
        //Max heap
        PriorityQueue<Integer> smallerQueue = new PriorityQueue<>(Collections.reverseOrder());
        smallerQueue.add(arr[0]);
        System.out.println(arr[0]);
        for(int i=1;i<arr.length;i++){
            int x = arr[i];
            if(smallerQueue.size()>greaterQueue.size()){
                if(smallerQueue.peek()<=x) greaterQueue.add(x);
                else {
                    int temp = smallerQueue.poll();
                    greaterQueue.add(temp);
                    smallerQueue.add(x);
                }
                float median = ((float)(smallerQueue.peek()+greaterQueue.peek()))/2;
                System.out.println((median%1==0)?(int)median:median);
            }
            else{
                if(greaterQueue.peek()>=x) smallerQueue.add(x);
                else {
                    int temp = greaterQueue.poll();
                    greaterQueue.add(x);
                    smallerQueue.add(temp);
                }
                System.out.println(smallerQueue.peek());
            }
        }

    }
}

// 12,15,10,5,8,7,16
// 12
// 12,15
// [10,12],[15]
// [5,10],[12,15]