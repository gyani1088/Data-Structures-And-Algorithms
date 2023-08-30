package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class SegregateEvenAndOddNodes {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,11);
        head =  insertAtBegin(head,5);
        head =  insertAtBegin(head,12);
        head =  insertAtBegin(head,18);
        head =  insertAtBegin(head,43);
        SinglyLinkedListTraversal.traversal(head);
        head = segregateEfficient(head);
        System.out.println("After segregating");
        SinglyLinkedListTraversal.traversal(head);

    }

    //Naive method : 2 traversals
    //Time complexity: O(n)
    //TODO: will do later
    @Deprecated
    public static Node segregateNaive(Node head){
        Node curr = head;
        //First traversal to get hold of the last node
        while(curr.next!=null){
            curr=curr.next;
        }
        Node tail = curr;
        Node oddTail = null, evenTail = null;

        return head;
    }

    public static Node segregateEfficient(Node head){
        Node evenStart = null, evenEnd=null, oddStart = null, oddEnd = null;
        Node curr = head;
        while(curr!=null){
            int x = curr.data;
            if(x%2==0){
                if(evenStart==null){
                    evenStart=evenEnd=curr;
                }
                else{
                    evenEnd.next = curr;
                    evenEnd=evenEnd.next;
                }
            }
            else{
                if(oddStart==null){
                    oddStart=oddEnd=curr;
                }
                else{
                    oddEnd.next = curr;
                    oddEnd=curr;
                }
            }
            curr=curr.next;
            }
        if(oddStart==null || evenStart==null) return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;

    }
}
