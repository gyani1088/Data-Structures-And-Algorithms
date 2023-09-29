package com.lucky.practice;

public class DequeImpl {
    private int[] arr;
    private int size, capacity;

    public DequeImpl(int capacity){
        size = 0;
        arr = new int[capacity];
        this.capacity = capacity;
    }

    boolean isFull(){
        return size==capacity;
    }
    boolean isEmpty(){
        return size==0;
    }
    void insertRear(int x){
        if(isFull()) return;
        arr[size]=x;
        size++;
    }
    void deleteRear(){
        if(isFull()) return;
        size--;
    }
    Integer getRear(){
        if(isEmpty()) return null;
        else return arr[size-1];
    }
    //Costly front insert O(n)
    void insertFront(int x){
        if(isFull()) return;
        for(int i=size-1;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=x;
        size++;
    }
    //Costly delete front operation : O(n)
    void deleteFront(){
        for(int i=1;i<=size-1;i++){
            arr[i-1]=arr[i];
        }
        size--;
    }
    Integer getFront(){
        if(isEmpty()) return null;
        else return arr[0];
    }
}
