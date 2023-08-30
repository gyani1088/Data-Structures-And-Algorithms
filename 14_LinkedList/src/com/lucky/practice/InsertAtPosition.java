package com.lucky.practice;

public class InsertAtPosition {
    public static void main(String[] args) {
        Node head = null;
        head = insert(head,30,0);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insert(head,20,1);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insert(head,10,0);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println();
        head = insert(head,5,2);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node insert(Node head, int x,int pos){
        int count=0;
        Node node = new Node(x);
        if (head==null && pos==0) return node;
        if (pos==0){
            node.next=head;
            return node;
        }
        Node curr = head;
        //curr should be one node before the location where we want to insert the new node
        while(curr!=null && count<pos-1){
            count++;
            curr=curr.next;
        }
        // the below sequence should be taken into consideration carefully
        node.next=curr.next;
        curr.next=node;
        return head;
    }
}
