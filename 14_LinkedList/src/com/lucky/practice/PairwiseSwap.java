package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class PairwiseSwap {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,10);
        head =  insertAtBegin(head,5);
        head =  insertAtBegin(head,0);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After pairwise swapping");
        head = pairwiseSwap_swappingLinks(head);
        SinglyLinkedListTraversal.traversal(head);

    }

    //Naive method : Swapping the data
    public static Node pairwiseSwap(Node head){
        Node curr = head;
        while(curr!=null && curr.next!=null){
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
        return head;
    }

    public static Node pairwiseSwap_swappingLinks(Node head){
        if(head==null || head.next==null) return head;
        Node curr = head.next.next;
        Node prev = head;
        head=head.next;
        head.next = prev;
        while(curr!=null && curr.next!=null){
            prev.next = curr.next;
            //pointing to the prev link for the next swap
            prev = curr;
            Node next = curr.next.next;
            //establishing the next link of curr.next(right link) the current link as the current link itself and making
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }
}
