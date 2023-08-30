package com.lucky.practice;

public class DoublyLinkedList_Insert {
    public static void main(String[] args) {
        DoublyLinkNode head = null;
        head = insertAtBegin(head, 50);
        head = insertAtBegin(head, 100);
        head = insertAtBegin(head, 200);
        DoublyLinkedListTraversal.traversal(head);
        System.out.println("=====================");
        head = insertAtEnd(head, 15);
        DoublyLinkedListTraversal.traversal(head);
    }
    public static DoublyLinkNode insertAtBegin(DoublyLinkNode head, int x){
        DoublyLinkNode node = new DoublyLinkNode(x);
        if (head==null) return node;
        node.next = head;
        head.prev = node;
        return node;
    }

    //Insert at end when the reference to only head of the LL is given
    public static DoublyLinkNode insertAtEnd(DoublyLinkNode head, int x){
        DoublyLinkNode node = new DoublyLinkNode(x);
        if (head==null) return node;
        DoublyLinkNode curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next = node;
        node.prev = curr;
        return head;
    }
}
