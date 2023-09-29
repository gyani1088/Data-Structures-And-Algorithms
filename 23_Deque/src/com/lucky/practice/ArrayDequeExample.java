package com.lucky.practice;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // See ArrayDeque documentations, it can act as stack, queue and deque (all functions of these three data structures)
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(20);
        arrayDeque.add(30);
        System.out.println(arrayDeque);
    }
}
