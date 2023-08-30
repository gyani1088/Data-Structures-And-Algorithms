package com.lucky.practice;

public class DoublyLinkedListTraversal {
    public static void traversal(DoublyLinkNode head){
        DoublyLinkNode curr = head;
        while(curr!=null){
            System.out.println(curr.data+" ");
            curr= curr.next;
        }
    }
}
