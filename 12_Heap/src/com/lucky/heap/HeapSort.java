package com.lucky.heap;

public class HeapSort {
    public static void main(String[] args) {
        int array[] ={80,20,15,40,50,100,25,45};
        MaxHeap maxHeap = new MaxHeap(array.length);

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        heapSort(maxHeap,array,0);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void heapSort(MaxHeap heap,int arr[],int rootIndex){
//        heap.arr =arr;
//        heap.size = arr.length;
        UpdateKey_Delete_Build.buildMaxHeap(arr,heap);
        for(int i=arr.length-1;i>=1;i--){
            Insertion.swap(arr,i,0);
            heap.size=i;
            HeapifyAndExtract.maxHeapify(heap,0);
        }
    }
}
