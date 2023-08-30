package com.lucky.practice;

import static com.lucky.practice.CircularLinkedList_Insert.insertAtBegin;

public class CircularLinkedList_Delete {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,10);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,40);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("After deleting the head");
        head = deleteHeadEfficient(head);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("After deleting the head");
        head = deleteHead(head);
        CircularLinkedListTraversal.traversal(head);
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,40);
        System.out.println("Adding 2 more elements");
        CircularLinkedListTraversal.traversal(head);
        head = deleteAtPos(head,2); // 40 30 10
        System.out.println("After deleting the element at pos 2");
        CircularLinkedListTraversal.traversal(head);
        head = deleteAtPos(head,0); // 30 10
        System.out.println("After deleting the element at pos 0");
        CircularLinkedListTraversal.traversal(head);



    }

    //Naive solution
    //Time complexity :O(n)
    public static Node deleteHead(Node head){
        if(head==null || head.next==head) return null;
        Node curr = head;
        while(curr.next!=head){
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    //Efficient solution
    //Time complexity: O(1)
    //We can delete the head.next in O(1) time
    public static Node deleteHeadEfficient(Node head){
        if(head==null || head.next==head) return null;
        Node curr = head.next;
        //Swap the data of head and head.next;
        head.data = curr.data;
        head.next = curr.next;
        return head;

    }

    public static Node deleteAtPos(Node head, int pos){
        if ((pos==0 && head.next==head) || head==null) return null;
        if (pos==0) return deleteHeadEfficient(head);
        Node curr = head;
        while(pos!=1){
            curr=curr.next;
            pos--;
        }
        //Deleting the node next to (pos-1)th Node
        curr.next = curr.next.next;
        return head;
    }
}
