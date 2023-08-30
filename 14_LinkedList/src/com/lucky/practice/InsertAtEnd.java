package com.lucky.practice;

public class InsertAtEnd {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtEnd(head,30);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insertAtEnd(head,20);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insertAtEnd(head,10);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head =  insertAtEnd(head,5);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node insertAtEnd(Node head, int x){
        Node newNode = new Node(x);
        Node p = head;
        if(p==null){
            return newNode;
        }
        while(p.next!=null){
            p=p.next;
        }
        p.next=newNode;
        return head;
    }
}
