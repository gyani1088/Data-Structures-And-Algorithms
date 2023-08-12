package com.lucky.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] array = {{10,20},{5,15},{4,9,11}};
        System.out.println(merge(array));
        System.out.println(merge2(array));
    }
    public static List<Integer> merge(int[][] arr2D){
        List<Integer> output = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((p1,p2)->p1.value-p2.value);
        for(int i=0;i<arr2D.length;i++){
            for(int j=0;j<arr2D[i].length;j++){
                minHeap.add(new Node(arr2D[i][j],i,j));
            }
        }
        while(!minHeap.isEmpty()) output.add(minHeap.poll().value);
        return output;
    }

    //Efficient Solution: taking into account the arrays are sorted
    //Time complexity: O(nk+nlogn)
    public  static List<Integer> merge2(int[][] arr2D){
        List<Integer> output = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((p1,p2)->p1.value-p2.value);
        for(int i=0;i<arr2D.length;i++){
                minHeap.add(new Node(arr2D[i][0],i,0));
        }
        while(!minHeap.isEmpty()){
            Node poll = minHeap.poll();
            output.add(poll.value);
            if(poll.elementIndex<arr2D[poll.arrayIndex].length-1)
                minHeap.add(new Node(arr2D[poll.arrayIndex][poll.elementIndex+1], poll.arrayIndex, poll.elementIndex+1));
        }
        return output;
    }
}

class Node{
    int value;
    int arrayIndex;
    int elementIndex;

    public Node(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
