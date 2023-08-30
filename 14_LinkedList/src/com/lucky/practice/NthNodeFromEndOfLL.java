package com.lucky.practice;

import static com.lucky.practice.SortedInsert_LL.insertInSortedOrder;

public class NthNodeFromEndOfLL {
    public static void main(String[] args) {
        Node head = null;
        head = insertInSortedOrder(head,10);
        head = insertInSortedOrder(head,40);
        head = insertInSortedOrder(head,30);
        head = insertInSortedOrder(head,20);
        head = insertInSortedOrder(head,25);
        head = insertInSortedOrder(head,80);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("Nth node from end of the list");
        printNthFromEnd(head,3);
        printNthFromEndEfficient(head,7);
    }
    public static void printNthFromEnd(Node head, int n){
        int len=0;
        for(Node curr=head;curr!=null;curr=curr.next)
            len++;
        if(len<n)
            return;
        Node curr=head;
        for(int i=1;i<len-n+1;i++)
            curr=curr.next;
        System.out.println(curr.data);
    }


    //One traversal approach
    public static void printNthFromEndEfficient(Node head, int n){
        if(head==null) return;
        Node first = head;
        for(int i=0;i<n;i++){
            //when n is greater than the length of the linked list
            if(first==null) return;
            first=first.next;
        }
        Node second = head;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        System.out.println(second.data);
    }
}
