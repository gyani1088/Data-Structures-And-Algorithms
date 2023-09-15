package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SegmentTreeImpl {

    private static final int N = 10;
    private static int[] preSum = new int[N];
    private static int[] arr = new int[N];
    private static int[] tree = new int[4 * N];

    public static void main(String[] args) {
        arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        tree[0]=constructSegmentTree(0,N-1,0);
        System.out.println(Arrays.stream(tree).mapToObj(i->i+"").collect(Collectors.joining(" ")));
        System.out.println(getSumRec(3,6,0,N-1,0));//4+5+6+7=22
        int newVal = 15, index=8;
        updateRec(0,9,index,0,newVal-arr[index]);
        System.out.println(Arrays.stream(tree).mapToObj(i->i+"").collect(Collectors.joining(" ")));
    }

    /**
     * Get Sum:
     * Update Element at index
     * <p>
     * Method1: get sum: add all the elements between the start and end index(inclusive) O(n)
     * update: Update the value at a specified index --- O(1)
     * <p>
     * Method2: Maintain a prefixSum array of size n
     * prefix sum has cumulative sum of all elements from 0 to given index (cumulative sum)
     * getSum: O(1)
     * update: O(n)
     */

    //Method 2:
    public void init() {
        preSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
    }

    public int getSum(int qs, int qe) {
        if (qs == 0) return preSum[qe];
        else return preSum[qe] - preSum[qs - 1];
    }

    public void update(int index, int updatedValue) {
        int diff = updatedValue - arr[index];
        arr[index] = updatedValue;
        for (int i = index; i < N; i++) {
            preSum[i] = preSum[i] + diff;
        }
    }

    //Method 3: Segment tree
    //Time complexity for construction: Theta(n)
    public static int constructSegmentTree(int start, int end, int treeIndex) {
        if (start == end) {
            tree[treeIndex] = arr[start];
            return arr[start];
        }
        int mid = (start+end)/2;
        tree[treeIndex]=constructSegmentTree(start,mid,2*treeIndex+1)+
                constructSegmentTree(mid+1,end,2*treeIndex+2);
        return tree[treeIndex];
    }

    public static int getSumRec(int qStart, int qEnd, int start, int end, int treeIndex){
        if (qStart>end || qEnd<start) return 0;
        else if (qStart<=start && qEnd>=end) return tree[treeIndex];
        int mid = (start+end)/2;
        return getSumRec(qStart,qEnd,start,mid,treeIndex*2+1)+
                getSumRec(qStart,qEnd,mid+1,end,treeIndex*2+2);
    }

    public static void updateRec(int start, int end, int i, int treeIndex, int diff){
        //when i doesn't fall in the range
        if(i<start || i>end) return;
        tree[treeIndex]+=diff;
        //checking if the node is a leaf node or not, if it is one, then find the mid and choose the range in which
        // i falls in, and update the value and don't update the other.
        if(start<end){
            int mid = (start+end)/2;
            updateRec(start, mid, i, treeIndex*2+1,diff);
            updateRec(mid+1,end, i, treeIndex*2+2,diff);
        }
    }
}
