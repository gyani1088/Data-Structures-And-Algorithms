package com.lucky.heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    int left(int i) {return 2*i+1;}
    int right(int i) {return 2*i+2;}
    int parent(int i) { return (i-1)/2;}
}
