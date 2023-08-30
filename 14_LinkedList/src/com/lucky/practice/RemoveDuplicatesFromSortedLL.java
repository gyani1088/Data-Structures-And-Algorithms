package com.lucky.practice;

import static com.lucky.practice.SortedInsert_LL.insertInSortedOrder;

public class RemoveDuplicatesFromSortedLL {
    public static void main(String[] args) {
        Node head = null;
        head = insertInSortedOrder(head,10);
        head = insertInSortedOrder(head,40);
        head = insertInSortedOrder(head,20);
        head = insertInSortedOrder(head,40);
        head = insertInSortedOrder(head,25);
        head = insertInSortedOrder(head,10);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After removing duplicates");
        removeDuplicates(head);
        SinglyLinkedListTraversal.traversal(head);
    }

    //head is not modified in this method
    public static void removeDuplicates(Node head){
        if(head==null || head.next==null) return;
        Node curr = head;
        while(curr.next!=null){
            if(curr.next.data==curr.data){
                curr.next = curr.next.next;
            }
            else curr=curr.next;
        }
    }
}
