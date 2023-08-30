package com.lucky.practice;

public class SinglyLinkedListTraversal {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp;
        temp.next = temp2;
        traversal(head);
        recursiveTraversal(head);
    }

    //Time complexity:O(n)
    public static void traversal(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr= curr.next;
        }
        System.out.println();
    }
    public static void recursiveTraversal(Node head){
        Node curr = head;
        if(curr==null) return;
        System.out.println(curr.data+" ");
        recursiveTraversal(curr.next);
    }
}
