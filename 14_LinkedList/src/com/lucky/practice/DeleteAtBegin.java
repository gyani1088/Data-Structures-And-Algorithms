package com.lucky.practice;

public class DeleteAtBegin {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp;
        temp.next = temp2;
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = deleteAtBegin(head);
        System.out.println("After deletion");
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node deleteAtBegin(Node head){
        if(head==null) return null;
        return head.next;

    }
}
