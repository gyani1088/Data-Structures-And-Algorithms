package com.lucky.practice;

public class LinkedListImpl {
    Node head;
    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        list.head.next = temp;
        temp.next = temp2;
    }
}
