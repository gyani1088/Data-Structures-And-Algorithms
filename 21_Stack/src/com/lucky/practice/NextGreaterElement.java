package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {10,20,15,30,40,25,12,30};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(greaterElementOnRHS(arr)));
    }

    /**
     * Time complexity: Theta(n)
     * Auxiliary Space: O(n)
     * */
    public static int[] greaterElementOnRHS(int[] arr){
        int n = arr.length;
        int[] output = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[n-1]);
        output[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            output[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        return output;
    }
}
