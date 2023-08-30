package com.lucky.practice;

import static com.lucky.practice.InsertAtBegin.insertAtBegin;

public class Search {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,30);
        head = insertAtBegin(head,20);
        head = insertAtBegin(head,10);
        head =  insertAtBegin(head,5);
        SinglyLinkedListTraversal.traversal(head);
        System.out.println(search(head,5));
        System.out.println(search(head,2));
        System.out.println(search(head,20));
        System.out.println(searchRecursive(head,5,-1));
        System.out.println(searchRecursive(head,2,-1));
        System.out.println(searchRecursive(head,20,-1));
        System.out.println(searchRecursive(head,5));
        System.out.println(searchRecursive(head,2));
        System.out.println(searchRecursive(head,20));
    }
    //Iterative approach
    public static int search(Node head,int x){
        int pos=-1;
        if(head==null) return pos;
        Node curr = head;
        while(curr!=null){
            pos++;
            if(curr.data==x) return pos;
            curr=curr.next;
        }
        return -1;
    }

    //Recursive
    public static int searchRecursive(Node head,int x,int pos){
        if(head==null) return -1;
        pos++;
        if(head.data==x) return pos;
        return searchRecursive(head.next,x,pos);
    }

    public static int searchRecursive(Node head,int x){
        if(head==null) return -1;
        if(head.data==x) return 0;
        int res =  searchRecursive(head.next,x);
        if(res ==-1) return -1;
        else return res+1;
    }
}
