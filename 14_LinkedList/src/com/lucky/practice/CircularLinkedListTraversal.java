package com.lucky.practice;

public class CircularLinkedListTraversal {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head;
        traversal(head);
    }
    public static void traversal(Node head){
        if(head==null) return;
        System.out.println(head.data);
        Node curr = head;
        while(curr.next!=head){
            curr=curr.next;
            System.out.println(curr.data);
        }
    }

    //Do-While loop
    public static void traversal2(Node head){
        if(head==null) return;
        Node curr = head;
        do{
            System.out.println(curr.data);
            curr=curr.next;
        }
        while(curr!=head);
    }

    public static void traversalWithTail_DLL(DoublyLinkNode tail){
        if(tail==null) return;
        DoublyLinkNode curr = tail.next;
        do{
            System.out.println(curr.data);
            curr=curr.next;
        }
        while(curr!=tail.next);
    }

    public static void traversalWithHead_DLL(DoublyLinkNode head){
        if(head==null) return;
        DoublyLinkNode curr = head;
        do{
            System.out.println(curr.data);
            curr=curr.next;
        }
        while(curr!=head);
    }
}
