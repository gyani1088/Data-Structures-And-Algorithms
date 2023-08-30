package com.lucky.practice;

public class InsertAtBegin {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insertAtBegin(head,20);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insertAtBegin(head,10);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head =  insertAtBegin(head,5);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node insertAtBegin(Node head, int x){
        Node newNode = new Node(x);
        newNode.next=head;
        head = newNode;
        return head;
    }
}
