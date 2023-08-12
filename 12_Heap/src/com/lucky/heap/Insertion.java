package com.lucky.heap;

public class Insertion {
    public static void main(String[] args) {
        int array[] ={10,20,15,40,50,100,25,45};
        MinHeap minHeap = new MinHeap(10);
        minHeap.size=array.length;
        for(int i=0;i<minHeap.size;i++){
            minHeap.arr[i]=array[i];
        }
        //Before insert
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        insert(minHeap,12);
        System.out.println();
        //After insert
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
    }
    public static void insert(MinHeap heap, int n){
        heap.size++;
        int currIndex = heap.size-1;
        heap.arr[currIndex]=n;
        int parentIndex = heap.parent(currIndex);
        while(heap.arr[currIndex]<heap.arr[parentIndex] && currIndex!=0){
            swap(heap.arr,currIndex,parentIndex);
            currIndex=parentIndex;
            parentIndex=heap.parent(parentIndex);
        }
    }

    public static void swap(int[] arr,int currIndex, int parentIndex) {
        int temp = arr[currIndex];
        arr[currIndex] = arr[parentIndex];
        arr[parentIndex] = temp;
    }
}
