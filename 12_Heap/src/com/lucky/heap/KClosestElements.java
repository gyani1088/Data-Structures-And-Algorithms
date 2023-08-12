package com.lucky.heap;

import java.util.*;

public class KClosestElements {
    public static void main(String[] args) {
        int[] array = {10,30,5,40,38,80,70};
        System.out.println(kClosestElements(array,35,3));
        System.out.println(kClosestEfficient(array,35,3));
    }
    //Naive
    //Time complexity: O(nk)
    public static List<Integer> kClosestElements(int[] array, int value, int maxClosest){
        boolean visited[] = new boolean[array.length];
        List<Integer> kClosest = new ArrayList<>();
        for(int i=0;i<maxClosest;i++){
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex=-1;
            for(int j=0;j< array.length;j++){
                if(visited[j]==false &&
                        (Math.abs(array[j]-value)<minDiff)){
                    minDiff=Math.abs(array[j]-value);
                    minDiffIndex=j;
                }
            }
            kClosest.add(array[minDiffIndex]);
            visited[minDiffIndex]=true;
        }
        return kClosest;
    }

    //Efficient Solution
    //O(klogk+(n-k)logk) =O(n logk)
    public static List<Integer> kClosestEfficient(int[] array,int value, int maxClosest){
        Comparator<Pair> comparator = (p1,p2)->p1.value-p2.value;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(comparator));
        for(int i=0;i<maxClosest;i++){
            pq.add(new Pair(Math.abs(array[i]-value),i));
        }
        for(int i=maxClosest;i<array.length;i++){
            if(pq.peek().value>Math.abs(array[i]-value)){
                pq.poll();
                pq.add(new Pair(Math.abs(array[i]-value),i));
            }
        }
        List<Integer> retVal = new ArrayList<>();
        while(!pq.isEmpty()){retVal.add(array[pq.poll().index]);}
        return retVal;
    }
}
class Pair{
    int value;
    int index;
    Pair(int value,int index){
        this.value = value;
        this.index = index;
    }
}