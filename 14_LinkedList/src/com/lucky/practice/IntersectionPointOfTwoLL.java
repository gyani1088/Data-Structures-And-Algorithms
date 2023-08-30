package com.lucky.practice;

import java.util.HashSet;

public class IntersectionPointOfTwoLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp;
        temp.next = temp2;
        temp2.next = temp3;
        //2nd LL
        Node head2 = new Node(-10);
        head2.next = temp2;
        System.out.println("LL1:");
        SinglyLinkedListTraversal.traversal(head);
        System.out.println("LL2:");
        SinglyLinkedListTraversal.traversal(head2);
        System.out.println("Intersection Point");
        System.out.println(findIntersection_UsingHashSet(head,head2).data);
        System.out.println(findIntersection_Efficient(head,head2).data);

    }

    //Time complexity : O(m+n)
    //Aux space: O(m)
    public static Node findIntersection_UsingHashSet(Node head1, Node head2){
        Node curr1 = head1;
        HashSet<Node> set = new HashSet<>();
        while(curr1!=null){
            set.add(curr1);
            curr1=curr1.next;
        }
        curr1 = head2;
        while(curr1!=null){
            if(set.contains(curr1)) return curr1;
            curr1=curr1.next;
        }
        return null;
    }


    //Time complexity:O(m+n)
    //Aux space: O(1)
    public static Node findIntersection_Efficient(Node head1, Node head2){
        int count1 = 0;
        for(Node curr = head1; curr!=null; curr = curr.next){
            count1++;
        }

        int count2 = 0;
        for(Node curr = head2; curr!=null; curr = curr.next){
            count2++;
        }
        Node curr1=head1, curr2=head2;
        while (count1>count2){
            curr1=curr1.next;
            count1--;
        }
        while (count2>count1){
            curr2=curr2.next;
            count2--;
        }
        while(curr1!=curr2){
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return curr1;
    }
}
