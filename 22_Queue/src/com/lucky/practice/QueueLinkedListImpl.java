package com.lucky.practice;

public class QueueLinkedListImpl {
    private Node front;
    private Node rear;
    private int size;

    public QueueLinkedListImpl(){
        size=0;
    }

    public int getSize(){
        return  size;
    }
    public void enqueue(int x){
        if(size==0) {
            rear = front = new Node(x);
        }
        else{
            rear.next = new Node(x);
            rear = rear.next;
        }
        size++;
    }
    public Integer dequeue(){
        if(size==0) return null;
        int val = front.data;
        front = front.next;
        size--;
        return val;
    }
    public Integer getFront(){
        if(size==0) return null;
        return front.data;
    }
    public Integer getRear(){
        if(size==0) return null;
        return rear.data;
    }
    boolean isEmpty(){
        return size==0;
    }

    static class Node {
        int data;
        Node next;
        Node(int x){
            data = x;
        }
    }
}

class Main{
    public static void main(String[] args) {
        QueueLinkedListImpl queue = new QueueLinkedListImpl();
        System.out.println(queue.getSize());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front="+queue.getFront()+",Rear="+queue.getRear()+",size="+queue.getSize());
        queue.dequeue();
        System.out.println("Front="+queue.getFront()+",Rear="+queue.getRear()+",size="+queue.getSize());
    }
}