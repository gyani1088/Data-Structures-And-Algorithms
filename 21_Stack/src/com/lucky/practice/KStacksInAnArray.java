package com.lucky.practice;

public class KStacksInAnArray {
    int[] arr;
    int[] tops;
    int[] next;
    int freeTop =0,k,capacity;

    /**
     * tops(top of the stack) -> freeTop(next index of the cursor in the array) -> next(
     * */
    KStacksInAnArray(int k, int capacity){
        this.k = k;
        this.capacity = capacity;
        arr = new int[capacity];
        tops = new int[k];
        next = new int[capacity];
        for(int i=0;i<k;i++){
            tops[i]=-1;
        }
        for(int i=0;i<capacity-1;i++){
            next[i]=i+1;
        }
        next[capacity-1]=-1;
    }
    //freeTop value is updated into tops[stackNum]
    void push(int stackNum, int val){
        int i = freeTop;
        freeTop = next[i];
        next[i] = tops[stackNum];
        tops[stackNum] = i;
        arr[i] = val;
    }

    //tops[stackNum] value is updated to freeTop
    int pop(int stackNum){
        int i = tops[stackNum];
        tops[stackNum] = next[i];
        next[i] = freeTop;
        freeTop = i;
        return arr[i];
    }

    boolean isEmpty(int stackNum){
        return tops[stackNum]==-1;
    }

    public static void main(String[] args) {
        KStacksInAnArray stacks = new KStacksInAnArray(3,5);
        stacks.push(0,1);
        stacks.push(2,2);
        stacks.push(0,3);
        stacks.push(1,4);
        stacks.pop(2);
        stacks.push(0,5);
        stacks.push(0,4);
    }
}
