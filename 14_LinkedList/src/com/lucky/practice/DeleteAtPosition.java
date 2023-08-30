package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class DeleteAtPosition {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,10);
        head = insertAtBegin(head,5);
        head = insertAtBegin(head,3);
        SinglyLinkedListTraversal.traversal(head);
        head = delete(head,6);
        System.out.println("After deletion");
        SinglyLinkedListTraversal.traversal(head);
        head = delete(head,0);
        System.out.println("After deletion");
        SinglyLinkedListTraversal.traversal(head);
        head = delete(head,2);
        System.out.println("After deletion");
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node delete(Node head, int pos){
        int count=0;
        if (head==null) return null;
        if (head.next==null && pos>0) return null;
        if (pos==0) return head.next;
        Node curr = head;
        while(count<pos-1 && curr.next.next!=null){
            count++;
            curr=curr.next;
        }
        if(count==pos-1){
            Node temp = curr.next;
            curr.next = curr.next.next;
            temp = null;
        }
        return head;
    }
}
