package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithGetMinFunction extends ArrayDeque<Integer>{
//    private Deque<Integer> mainStack;
    private Deque<Integer> auxStack;

    StackWithGetMinFunction(int capacity){
        super(capacity);
        auxStack = new ArrayDeque<>(capacity);
    }
    public static void main(String[] args) {
        StackWithGetMinFunction stack = new StackWithGetMinFunction(10);
        stack.push(10);
        stack.push(5);
        stack.push(20);
        stack.push(12);
        System.out.println("min="+stack.getMin());
        System.out.println("top="+stack.pop());
        System.out.println("min="+stack.getMin());
        System.out.println("top="+stack.pop());
        System.out.println("min="+stack.getMin());
        System.out.println("top="+stack.pop());
        System.out.println("min="+stack.getMin());
        System.out.println("top="+stack.pop());
    }

    @Override
    public void push(Integer integer) {
        super.push(integer);
        if(auxStack.isEmpty() || integer<=auxStack.peek()) auxStack.push(integer);
    }

    @Override
    public Integer pop() {
        int val = super.pop();
        if(val==auxStack.peek()) auxStack.pop();
        return  val;
    }

    //Auxiliary space: O(n)
    public int getMin(){
        return auxStack.isEmpty()?Integer.MAX_VALUE:auxStack.peek();
    }
}
