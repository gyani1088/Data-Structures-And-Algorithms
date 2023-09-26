package com.lucky.practice;

//All operation of stack are of O(1) time complexity for the worst case
public class StackImplLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int x){
            data=x;
        }
    }

    private Node head;
    private int size;

    StackImplLinkedList(){
        head=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head==null;
    }
    //Insert at beginning
    //Time complexity:O(1)
    public void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
    }
    //Removing from the beginning
    //Time complexity: O(1)
    public int pop(){
        if(head==null) throw new RuntimeException("Underflow");
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }
    //Time complexity: O(1)
    public int peek(){
        if(head==null) throw new RuntimeException("Underflow");
        return head.data;
    }
}
