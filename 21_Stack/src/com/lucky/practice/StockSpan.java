package com.lucky.practice;

import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        int arr[] = {10,30,25,30,4,21,22,15,4,2,15,25};
        System.out.println(Arrays.toString(arr));
        System.out.println(stockSpan(arr));
    }

    //Time complexity: Theta(n) --> Each element is pushed to stack exactly once and popped at most once
    //Auxiliary space: O(n)
    public static List<Integer> stockSpan(int arr[]){
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        stack.push(0);
        output.add(1);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            output.add(span);
            stack.push(i);
//            System.out.println(stack.toString());
        }
        return output;
    }
}
