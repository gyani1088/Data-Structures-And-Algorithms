package com.lucky.practice;

import static com.lucky.practice.SortedInsert_LL.insertInSortedOrder;

public class MiddleOfLL {
    public static void main(String[] args) {
        Node head = null;
        head = insertInSortedOrder(head,10);
        head = insertInSortedOrder(head,40);
        //head = insertInSortedOrder(head,30);
        //head = insertInSortedOrder(head,20);
        //head = insertInSortedOrder(head,25);
        //head = insertInSortedOrder(head,80);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("Middle");
        printMiddle(head);
    }
    //concept of slow and fast pointers
    public  static void printMiddle(Node head){
        if (head==null) return;
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }
}
