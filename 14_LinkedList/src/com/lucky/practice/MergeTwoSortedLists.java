package com.lucky.practice;

import static com.lucky.practice.SortedInsert_LL.insertInSortedOrder;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node head1 = null;
        head1 = insertInSortedOrder(head1,10);
        head1 = insertInSortedOrder(head1,40);
        head1 = insertInSortedOrder(head1,30);
        head1 = insertInSortedOrder(head1,20);
        head1 = insertInSortedOrder(head1,25);
        head1 = insertInSortedOrder(head1,80);
        SinglyLinkedListTraversal.traversal(head1);

        Node head2 = null;
        head2 = insertInSortedOrder(head2,5);
        head2 = insertInSortedOrder(head2,22);
        head2 = insertInSortedOrder(head2,15);
        head2 = insertInSortedOrder(head2,28);
        head2 = insertInSortedOrder(head2,25);
        head2 = insertInSortedOrder(head2,75);
        SinglyLinkedListTraversal.traversal(head2);

        Node newList = mergeSortedLists(head1, head2);
        SinglyLinkedListTraversal.traversal(newList);
    }
    public static Node mergeSortedLists(Node head1, Node head2){
        Node mergedHead = null;
        Node mergedTail = null;
        if(head1==null) return head2;
        if(head2==null) return head1;
        if(head1.data<head2.data) {
            mergedHead=mergedTail=head1;
            head1=head1.next;
        }
        else {
            mergedHead=mergedTail=head2;
            head2=head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                mergedTail.next=head1;
                mergedTail=mergedTail.next;
                head1=head1.next;
            }
            else{
                mergedTail.next=head2;
                mergedTail=mergedTail.next;
                head2=head2.next;
            }
        }
        if(head1==null) mergedTail.next=head2;
        else mergedTail.next=head1;
        return mergedHead;
    }
}
