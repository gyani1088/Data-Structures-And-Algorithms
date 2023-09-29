package com.lucky.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {
    private int[] arr;
    private int front,rear;
    private int size,capacity;

    public QueueImpl(int capacity){
        arr = new int[capacity];
        size=0;
        front=0;
        rear=-1;
        this.capacity=capacity;
    }

    public void enqueue(int x){
        if(isFull()) return;
        rear=(rear+1)%capacity;
        arr[rear]=x;
        size++;
    }

    public int dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        int last = front;
        front = (front+1)%capacity;
        size--;
        return arr[last];
    }
    int size(){
        return size;
    }
    public int getFront(){
        if(isEmpty()) return -1;
        return front;
    }
    public int getRear(){
        if(isEmpty()) return -1;
        return rear;
    }

    boolean isFull(){
        return size==capacity;
    }
    boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(4);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(" size:"+ queue.size()+" "+queue.dequeue()+" size:"+ queue.size()+" (front,rear)=("+ queue.getFront()+","+queue.getRear()+")");
        System.out.println(" size:"+ queue.size()+" "+queue.dequeue()+" size:"+ queue.size()+" (front,rear)=("+ queue.getFront()+","+queue.getRear()+")");
        System.out.println(" size:"+ queue.size()+" "+queue.dequeue()+" size:"+ queue.size()+" (front,rear)=("+ queue.getFront()+","+queue.getRear()+")");
        System.out.println(" size:"+ queue.size()+" "+queue.dequeue()+" size:"+ queue.size()+" (front,rear)=("+ queue.getFront()+","+queue.getRear()+")");
        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println(" size:"+ queue.size()+" "+queue.dequeue()+" size:"+ queue.size()+" (front,rear)=("+ queue.getFront()+","+queue.getRear()+")");
//        System.out.println(queue.dequeue());
    }
}
