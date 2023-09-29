package com.lucky.practice;

import java.util.ArrayDeque;

public class DesignMinToMaxQueue {
    private ArrayDeque<Integer> dq;
    DesignMinToMaxQueue(){
        dq = new ArrayDeque<>();
    }
    void insertMin(int x){
        if(dq.isEmpty() || x<dq.peekFirst()) dq.offerFirst(x);
    }
    void insertMax(int x){
        if (dq.isEmpty() || x>dq.peekLast()) dq.offerLast(x);
    }
    Integer getMin(){ return dq.peekFirst();}
    Integer getMax(){ return dq.peekLast();}
    Integer extractMin(){
        return dq.pollFirst();
    }
    Integer extractMax(){
        return dq.pollLast();
    }

    public static void main(String[] args) {
        DesignMinToMaxQueue myDS = new DesignMinToMaxQueue();
        System.out.println(myDS.getMin());
        myDS.insertMin(10);
        myDS.insertMin(5);
        myDS.insertMin(20);
        System.out.println(myDS.getMin());
        System.out.println(myDS.getMax());
        System.out.println(myDS.extractMax());
        myDS.insertMax(10);
        myDS.insertMax(20);
        System.out.println(myDS.getMin());
        System.out.println(myDS.getMax());
    }
}
