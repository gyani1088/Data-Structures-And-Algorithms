package com.lucky.practice;

import java.util.Arrays;

public class DequeImpl_CircularArray {
    private int[] arr;
    private int size, capacity,front;

    public DequeImpl_CircularArray(int capacity){
        size = 0;
        arr = new int[capacity];
        this.capacity = capacity;
        front = 0;
    }
    boolean isFull(){
        return size==capacity;
    }
    boolean isEmpty(){
        return size==0;
    }
    void insertFront(int x){
        if(isFull()) return;
        front = (front-1+capacity)%capacity;
        arr[front]=x;
        size++;
    }
    void deleteFront(){
        if (isEmpty()) return;
        front = (front+1)%capacity;
        size--;
    }
    Integer getFront(){
        if(isEmpty()) return null;
        return arr[front];
    }
    void insertRear(int x){
        if(isFull()) return;
        arr[(front+size)%capacity]=x;
        size++;
    }
    void deleteRear(){
        if (isEmpty()) return;
        size--;
    }
    Integer getRear(){
        if(isEmpty()) return null;
        return arr[(front+size-1)%capacity];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        DequeImpl_CircularArray deque = new DequeImpl_CircularArray(4);
        deque.insertFront(10);
        deque.insertFront(20);
        deque.insertRear(30);
        System.out.println(deque);
        deque.deleteRear();
        deque.deleteRear();
        System.out.println(deque.getFront()+" , "+deque.getRear());
    }
}
