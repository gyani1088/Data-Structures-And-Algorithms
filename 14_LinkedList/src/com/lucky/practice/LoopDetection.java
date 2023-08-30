package com.lucky.practice;

import java.util.HashSet;

public class LoopDetection {
    public static void main(String[] args) {

        Node head = new Node(10);
        Node temp = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        head.next = temp;
        temp.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp2;
        System.out.println(detectLoop_UsingHashSet(head));
        System.out.println(detectLoop_UsingFloydDetection(head));
    }

    //link list won't be available for further operations as the structure will be broken
    public static boolean detectLoop_UsingDummyNode(Node head){
        Node dummy = new Node(0);
        Node curr = head;
        while(curr!=null){
            if(curr.next==dummy) return true;
            else{
                Node temp = curr;
                curr=curr.next;
                temp.next=dummy;
            }
        }
        return false;
    }

    public static boolean detectLoop_UsingHashSet(Node head){
        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while(curr!=null){
            if(set.contains(curr)) return true;
            set.add(curr);
            curr=curr.next;
        }
        return false;
    }

    //Floyd cycle detection
    public static boolean detectLoop_UsingFloydDetection(Node head){
        Node slow =head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            //initially both are at head, so this check needs to be tested once we have moved the references slow and fast
            if(slow==fast) return true;
        }
        return false;
    }
}
