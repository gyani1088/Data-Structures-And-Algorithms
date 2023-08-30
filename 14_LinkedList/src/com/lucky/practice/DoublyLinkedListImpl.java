package com.lucky.practice;

public class DoublyLinkedListImpl {
    public static void main(String[] args) {
        DoublyLinkNode head = new DoublyLinkNode(50);
        DoublyLinkNode temp1 = new DoublyLinkNode(100);
        DoublyLinkNode temp2 = new DoublyLinkNode(200);
        head.next = temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
    }
}
