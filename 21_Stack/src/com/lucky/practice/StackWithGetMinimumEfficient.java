package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * For this implementation we are overriding only the functions that are relevant, but this may behave badly in
 * extension if we use the methods that are not overridden and are present in the parent class.
 * */
public class StackWithGetMinimumEfficient{
    private Integer min = null;
    private Deque<Integer> stack;

    public StackWithGetMinimumEfficient() {
        this.stack = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        StackWithGetMinimumEfficient stack = new StackWithGetMinimumEfficient();
        stack.push(5);
        stack.push(10);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.stack.toString());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.peek());
    }

    public void push(Integer integer) {
        if(stack.isEmpty()) {
            min = integer;
            stack.push(integer);
        }
        else if(integer<=min){
            int temp = 2*integer-min;
            min = integer;
            stack.push(temp);
        }
        else stack.push(integer);
    }

    public Integer pop() {
        int temp = stack.pop();
        //min = 2, temp =-1
        if(temp<=min){
            int res = min;
            min = 2*min-temp;
            return res;
        }
        else return temp;

    }

    public Integer peek() {
        int temp = stack.peek();
        //min = 2, temp =-1
        if(temp<=min){
            int res = min;
            min = 2*min-temp;
            return res;
        }
        else return temp;

    }

    public int getMin(){
        return min;
    }

}
