package com.lucky.practice;

import static com.lucky.practice.DoublyLinkedList_Insert.insertAtBegin;
import static com.lucky.practice.DoublyLinkedList_Insert.insertAtEnd;

public class DoublyLinkedListReverse {
    public static void main(String[] args) {
        DoublyLinkNode head = null;
        head = insertAtBegin(head, 50);
        head = insertAtBegin(head, 100);
        head = insertAtBegin(head, 200);
        head = insertAtEnd(head, 15);
        DoublyLinkedListTraversal.traversal(head);
        System.out.println("=====================");
        head = reverse(head);
        DoublyLinkedListTraversal.traversal(head);
    }
    public static DoublyLinkNode reverse(DoublyLinkNode head){
        if (head==null || head.next==null) return head;
        DoublyLinkNode curr = head;
        DoublyLinkNode prev = null;
        while(curr!=null){
            prev = curr.prev;
            //curr.prev=null at the end of traversal
            curr.prev = curr.next;
            curr.next = prev;
            //update curr with curr.prev and not curr.next because curr.next is already reversed to curr.prev value
            curr=curr.prev;
        }
        return prev.prev;
    }
}
