package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class ReverseALinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,10);
        head = insertAtBegin(head,5);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("======================");
        head = reverse(head);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("======================");
        head = recursiveMethod1(head);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("======================");
        head = recursiveMethod2(head,null);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            //null 10 20 null
            next = curr.next;//next: 20 null
            curr.next = prev;//curr.next: null 10
            prev = curr;//prev: 10 20
            curr = next;//curr: 20 null
        }
        return prev;
    }

    //Recursive Approach 1
    public static Node recursiveMethod1(Node head){
        //Base cases
        if(head==null || head.next==null) return head;
        Node restHead = recursiveMethod1(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;
        return restHead;
    }

    //Recursive Approach 2
    public static Node recursiveMethod2(Node curr,Node prev){
        //Base cases
        if(curr==null) return prev;
        Node next = curr.next;
        curr.next=prev;
        return recursiveMethod2(next,curr);
    }
}
