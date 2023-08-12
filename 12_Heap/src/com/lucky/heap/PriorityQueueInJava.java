package com.lucky.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueInJava {
    public static void main(String[] args) {
        //Uses a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //uses a max heap
        PriorityQueue<Integer> pq2 =  new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq2.add(10);
        pq2.add(20);
        pq2.add(15);
        System.out.println(pq.peek()+","+pq2.peek());// 10,20
        System.out.println(pq.poll()+","+pq2.poll());// 10,20
        System.out.println(pq.peek()+","+pq2.peek());// 15,15
    }
}
