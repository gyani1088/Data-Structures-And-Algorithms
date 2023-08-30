package com.lucky.practice;

public class DeleteNodeWithOnlyRef_AndNoHeadRef {
    public static void main(String[] args) {

        Node head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        head.next = temp;
        temp.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        SinglyLinkedListTraversal.traversal(head);
        delete(temp);
        System.out.println("After Deleting 20 (2nd node)");
        SinglyLinkedListTraversal.traversal(head);
    }
    public static void delete(Node ptr){
        ptr.data = ptr.next.data;
        ptr.next = ptr.next.next;
    }
}
