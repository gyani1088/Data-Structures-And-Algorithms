package com.lucky.practice;

public class CircularDLL {
    public static void main(String[] args) {
        DoublyLinkNode head = null;
        head = InsertAtBegin(head,40);
        head = InsertAtBegin(head,30);
        head = InsertAtBegin(head,20);
        head = InsertAtBegin(head,10);
        CircularLinkedListTraversal.traversalWithHead_DLL(head);
    }
    public static DoublyLinkNode InsertAtBegin(DoublyLinkNode head,int x){
        DoublyLinkNode node = new DoublyLinkNode(x);
        if(head==null){
            node.next=node;
            node.prev=node;
            return node;
        }
        else{
            node.next=head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
            return node;
        }
    }
    //same as insert at begin except we return the old head in this case instead of the new node as head
    public static DoublyLinkNode InsertAtEnd(DoublyLinkNode head,int x){
        DoublyLinkNode node = new DoublyLinkNode(x);
        if(head==null){
            node.next=node;
            node.prev=node;
            return node;
        }
        else{
            node.next=head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
            return head;
        }
    }
}
