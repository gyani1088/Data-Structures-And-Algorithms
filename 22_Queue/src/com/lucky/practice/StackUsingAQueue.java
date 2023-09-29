package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingAQueue {
    Queue<Integer> q1,q2;
    StackUsingAQueue(){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    Integer top(){
        return q1.peek();
    }
    Integer pop(){
        return q1.poll();
    }
    int size(){
        return q1.size();
    }
    void push(int x){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public static void main(String[] args) {
        StackUsingAQueue stack = new StackUsingAQueue();
        stack.push(10);
        System.out.println(stack.top());
        stack.push(20);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

