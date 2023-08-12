package com.lucky.heap;

public class UpdateKey_Delete_Build {
    public static void main(String[] args) {
        int array[] ={80,20,15,40,50,100,25,45};
        MinHeap minHeap = new MinHeap(10);
        minHeap.size=array.length;
        for(int i=0;i<minHeap.size;i++){
            minHeap.arr[i]=array[i];
        }
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        System.out.println();
        HeapifyAndExtract.minHeapify(minHeap,0);
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        modifyAndUpdate(minHeap,5,5);
        System.out.println();
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        deleteAndUpdate(minHeap,2);
        System.out.println();
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        int arr[] = {10,20,15,18,24,5,45,30,35};
        buildHeap(arr,new MinHeap(arr.length));
        System.out.println("\narr:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void modifyAndUpdate(MinHeap heap, int index, int value){
        if(index>=heap.size) return;
        heap.arr[index]=value;
        //updating the minHeap (same as insert) -- can be moved out as a method
        updateMinHeap(heap, index);
    }

    public static void updateMinHeap(MinHeap heap, int index) {
        int parentIndex = heap.parent(index);
        while(heap.arr[index]< heap.arr[parentIndex] && index!=0){
            Insertion.swap(heap.arr, index,parentIndex);
            index =parentIndex;
            parentIndex= heap.parent(parentIndex);
        }
    }

    //update the element at the index to be deleted with value "-infinity"
    //extract minimum in the process, which would be -infinity
    //replace the last element in the array with the root i.e. arr[0] which is -infinity
    //and then update the heap using heapify method
    public static void deleteAndUpdate(MinHeap heap, int index){
        heap.arr[index]=Integer.MIN_VALUE;
        //internally calls the minHeapify method, where the heap.arr[heap.size-1] replaces the root
        //and calls minHeapify recursively
        updateMinHeap(heap,index);
        HeapifyAndExtract.extractMinimum(heap);
    }

    //Build heap: Given a random array, rearrange it into a minHeap
    //Time complexity: O(n log n)
    public static void buildHeap(int[] arr, MinHeap heap){
        heap.arr = arr;
        heap.size = arr.length;
        for (int i=(heap.size-2)/2;i>=0;i--){
            //parent nodes used in this case where, they are swapped by smallest child element
            //ending up in accumulation of smaller elements towards the root and eventually
            //smallest at the root

            //lower levels are heapified first
            HeapifyAndExtract.minHeapify(heap,i);
        }
    }

    public static void buildMaxHeap(int[] arr, MaxHeap heap){
        heap.arr = arr;
        heap.size = arr.length;
        for (int i=(heap.size-2)/2;i>=0;i--){
            HeapifyAndExtract.maxHeapify(heap,i);
        }

    }
}
