package com.lucky.practice;

import static com.lucky.practice.DoublyLinkedList_Insert.insertAtBegin;

public class DoublyLinkedListDelete {
    public static void main(String[] args) {
        DoublyLinkNode head = null;
        head = insertAtBegin(head, 20);
        head = insertAtBegin(head, 50);
        head = insertAtBegin(head, 100);
        head = insertAtBegin(head, 200);
        DoublyLinkedListTraversal.traversal(head);
        System.out.println("Delete at begin");
        head = deleteAtBegin(head);
        DoublyLinkedListTraversal.traversal(head);
        head = insertAtBegin(head, 200);
        System.out.println("======================");
        DoublyLinkedListTraversal.traversal(head);
        System.out.println("Delete at end");
        head = deleteAtEnd(head);
        DoublyLinkedListTraversal.traversal(head);
    }
    public static DoublyLinkNode deleteAtBegin(DoublyLinkNode head){
        if(head==null || head.next==null) return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }
    public static DoublyLinkNode deleteAtEnd(DoublyLinkNode head){
        if(head==null || head.next==null) return null;
        DoublyLinkNode curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.prev.next=null;
        return head;
    }
}
