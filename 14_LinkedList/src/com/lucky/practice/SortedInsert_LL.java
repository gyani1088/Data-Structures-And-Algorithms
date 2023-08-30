package com.lucky.practice;

public class SortedInsert_LL {
    public static void main(String[] args) {
        Node head = null;
        head = insertInSortedOrder(head,10);
        head = insertInSortedOrder(head,40);
        head = insertInSortedOrder(head,30);
        head = insertInSortedOrder(head,20);
        head = insertInSortedOrder(head,25);
        head = insertInSortedOrder(head,80);
        SinglyLinkedListTraversal.traversal(head);
    }
    public static Node insertInSortedOrder(Node head,int x){
        Node node = new Node(x);
        if(head==null) return node;
        if(head.data>=node.data){
            node.next = head;
            return node;
        }
        else{
            Node curr = head;
            while(curr.next!=null && curr.next.data<node.data){
                curr=curr.next;
            }
            node.next = curr.next;
            curr.next = node;
            return head;
        }
    }
}


// 10 20 30 40 ------- 25