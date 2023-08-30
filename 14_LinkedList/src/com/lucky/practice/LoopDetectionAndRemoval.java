package com.lucky.practice;

public class LoopDetectionAndRemoval {
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
        System.out.println(LoopDetection.detectLoop_UsingFloydDetection(head));
        detectAndRemoveLoop(head);
        System.out.println(LoopDetection.detectLoop_UsingFloydDetection(head));
    }
    public static void detectAndRemoveLoop(Node head){
        Node slow = head, fast =head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast!=slow) return;
        //restarting, keeping fast at the same point and slow at the beginning and increasing both by one node at a time
        slow = head;
        if(slow==fast)
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }
}
