package com.lucky.practice;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(10); //Doesn't throw exception
        deque.offerFirst(20);
        deque.offerLast(5);
        deque.offerLast(15);
        Iterator<Integer> it = deque.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}
