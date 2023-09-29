package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class MaxOfAllSubArraysOfSizeK {
    public static void main(String[] args) {
        int arr[] ={10,8,5,7,12,15,7,6};
        System.out.println(Arrays.toString(printMaxK(arr,3)));//10 8 12 15 15 15
        arr =new int[]{10,9,8,7,6,5,4};
        System.out.println(Arrays.toString(printMaxK(arr,3)));//10 9 8 7 6
    }

    //Time complexity: O(n)
    //Every element goes into the deque exactly once and is polled out exactly once
    //Aux space: O(k)
    public static int[] printMaxK(int arr[], int k){
        int n = arr.length;
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && arr[i]>=arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        for(int i=k;i<n;i++){
            res[i-k] = arr[deque.peekFirst()];
            if(!deque.isEmpty() && deque.peekFirst()<=i-k)
                deque.removeFirst();
            while(!deque.isEmpty() && arr[i]>=arr[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        res[n-k] = arr[deque.peekFirst()];
        return res;
    }
}

// 10 8 5 7 12 15 7 6
//     10 8 12 15 15 15
//we maintain a deque of size k, we remove the last element from the dq in these cases:
//  1. we get an element greater than the element at the rear. we continue to delete the rear element and insert the curr
//      element.
// 10 8 5
// 8 7
// 12
// 15
// 15 7