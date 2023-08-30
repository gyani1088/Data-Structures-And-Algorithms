package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class DeleteAtEnd {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,10);
        head = insertAtBegin(head,5);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After deleting the last item");
        head = deleteAtEnd(head);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After deleting the last item");
        head = deleteAtEnd(head);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After deleting the last item");
        head = deleteAtEnd(head);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("After deleting the last item");
        head = deleteAtEnd(head);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node deleteAtEnd(Node head){
        if(head==null) return null;
        else if(head.next==null) return null;
        Node curr = head;
        while (curr.next.next!=null){
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }
}
