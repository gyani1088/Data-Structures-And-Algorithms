package com.lucky.practice;

public class TwoStacksFromAnArray {
    private int arr[];
    private int top1,top2,capacity;

    TwoStacksFromAnArray(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
        top1=-1;
        top2=capacity;
    }

    boolean push1(int x){
        if(top1<top2-1){
            arr[++top1]=x;
            return true;
        }
        return false;
    }

    boolean push2(int x){
        if(top2>top1+1){
            arr[--top2]=x;
            return true;
        }
        return false;
    }

    Integer pop1(){
        if(top1>=0) {
            int x = arr[top1--];
            return x;
        }
        return null;
    }

    Integer pop2(){
        if(top2<capacity) {
            int x = arr[top2];
            top2++;
            return x;
        }
        return null;
    }

    int size1(){
        return top1+1;
    }

    int size2(){
        return capacity-top2;
    }
    public static void main(String[] args) {
        TwoStacksFromAnArray stacks = new TwoStacksFromAnArray(10);
        stacks.push1(15);
        stacks.push1(20);
        stacks.push1(25);
        stacks.push1(30);
        stacks.push1(35);
        stacks.push1(40);
        System.out.println(stacks.size1());
        System.out.println(stacks.size2());
        stacks.push2(10);
        stacks.push2(100);
        System.out.println(stacks.size1());
        System.out.println(stacks.size2());
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop2());
        System.out.println(stacks.top2);
    }
}
