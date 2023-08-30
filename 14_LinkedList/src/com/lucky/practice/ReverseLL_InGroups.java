package com.lucky.practice;

import static com.lucky.practice.SortedInsert_LL.insertInSortedOrder;

public class ReverseLL_InGroups {
    public static void main(String[] args) {
        Node head = null;
        head = insertInSortedOrder(head,10);
        head = insertInSortedOrder(head,40);
        head = insertInSortedOrder(head,30);
        head = insertInSortedOrder(head,20);
        head = insertInSortedOrder(head,25);
        head = insertInSortedOrder(head,80);
        head = insertInSortedOrder(head,100);
        SinglyLinkedListTraversal.traversal(head);
        head = reverseK(head,3);
        System.out.println("==============================");
        SinglyLinkedListTraversal.traversal(head);
        head = reverseK_Iterative(head,3);
        System.out.println("==============================");
        SinglyLinkedListTraversal.traversal(head);
    }
    //Recursive solution
    //Time complexity :O(n)
    //Aux space : O(n/k)
    public  static Node reverseK(Node head,int k){
        Node curr = head, next = null, prev = null;
        int count =0;
        while(curr!=null &&  count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            Node restHead = reverseK(next,k);
            head.next = restHead;
        }
        return prev;
    }

    public static Node reverseK_Iterative(Node head,int k){
        //prevFirst refers to the first node (i.e. end node after reverse) of the previous group
        Node curr = head, prevFirst = null;
        //isFirstPass set to true for the first group where we maintain a head
        // that will eventually be the head of the end loop
        boolean isFirstPass = true;
        while(curr!=null){
            Node first = curr, prev = null, next =null;
            int count=0;
            while(curr!=null && count<k){
                next = curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            if(isFirstPass) {
                head = prev;
                isFirstPass = false;
            }
            else prevFirst.next = prev;
            prevFirst= first;
        }
        return head;
    }
}
