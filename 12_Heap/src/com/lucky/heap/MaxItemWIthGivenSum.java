package com.lucky.heap;

public class MaxItemWIthGivenSum {
    public static void main(String[] args) {
        int array[] ={80,55,15,40,50,100,25,45};
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println(maxItems(array,100));
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    //Time complexity: O(n) = O(res*logn)
    public static int maxItems(int[] arr, int sum){
        MinHeap minHeap = new MinHeap(arr.length);
        minHeap.size=arr.length;
        minHeap.arr=arr;
        UpdateKey_Delete_Build.buildHeap(arr,minHeap);
        int res=0;
        while (sum>=0) {
            sum-=HeapifyAndExtract.extractMinimum(minHeap);
            System.out.println(sum);
            if(sum>=0) res++;
        }
        return res;
    }
}
