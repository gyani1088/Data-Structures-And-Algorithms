package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {10,20,15,30,40,25,12,30};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(greaterElementOnLHS(arr)));
    }
    /**
     * Input : [10,20,15,30,40,25,12,30]
     * Answer: [-1,-1,20,-1,-1,40,25,40]
     *
     * Time complexity: Theta(n)
     * Auxiliary Space: O(n)
     * */
    public static int[] greaterElementOnLHS(int arr[]){
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[n];
        stack.push(arr[0]);
        output[0]=-1;
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            int nextGreater = stack.isEmpty()?-1:stack.peek();
            output[i] = nextGreater;
            stack.push(arr[i]);
        }
        return output;
    }
}
