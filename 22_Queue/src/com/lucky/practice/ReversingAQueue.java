package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReversingAQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.toString());
        reverse(queue);
        System.out.println("After reverse:\n"+queue.toString());
        reverseRec(queue);
        System.out.println("After reverse(using recursion):\n"+queue.toString());
    }
    //Using a stack
    public static void reverse(Queue<Integer> queue){
        Deque<Integer> stack = new ArrayDeque<>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
    //Using recursion (call stack)
    public static void reverseRec(Queue<Integer> queue){
        if(queue.isEmpty()) return;
        int x = queue.poll();
        reverseRec(queue);
        queue.add(x);
    }
}
