package com.lucky.heap;

public class HeapifyAndExtract {
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
        minHeapify(minHeap,0);
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        System.out.println();
        System.out.println(extractMinimum(minHeap));
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
        System.out.println();
        System.out.println(extractMinimum(minHeap));
        for(int i=0;i<minHeap.size;i++){
            System.out.print(minHeap.arr[i]+" ");
        }
    }

    //Aux space :O(log n)
    //Time complexity: O(log n)
    public static void minHeapify(MinHeap heap, int i){
        int lt = heap.left(i);
        int rt = heap.right(i);
        int smallest = i;
        if (lt<heap.size && heap.arr[lt]<heap.arr[i]) smallest = lt;
        if (rt<heap.size && heap.arr[rt]<heap.arr[smallest]) smallest = rt;
        if(smallest!=i){
            Insertion.swap(heap.arr, smallest,i);
            minHeapify(heap,smallest);
        }
    }

    /*
    * i -> index of the root
     */
    public static void maxHeapify(MaxHeap heap, int rootIndex){
        int lt = heap.left(rootIndex);
        int rt = heap.right(rootIndex);
        int largest = rootIndex;
        if (lt<heap.size && heap.arr[lt]>heap.arr[rootIndex]) largest = lt;
        if (rt<heap.size && heap.arr[rt]>heap.arr[largest]) largest = rt;
        if(largest!=rootIndex){
            Insertion.swap(heap.arr, largest,rootIndex);
            maxHeapify(heap,largest);
        }
    }
    public static int extractMinimum(MinHeap heap){
        if(heap.size==0) return Integer.MAX_VALUE;
        int min = heap.arr[0];
        Insertion.swap(heap.arr,heap.size-1,0);
        heap.size--;
        minHeapify(heap,0);
        return min;
    }

}
