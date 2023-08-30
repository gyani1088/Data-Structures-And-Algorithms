package com.lucky.practice;

import java.util.Stack;

public class PalindromeLinkedList {

    static class Node{
        char character;
        Node next;

        public Node(char character) {
            this.character = character;
        }
    }

    public static void main(String[] args) {
        Node head = new Node('G');
        head.next = new Node('E');
        head.next.next = new Node('E');
        head.next.next.next = new Node('K');
        head.next.next.next.next = new Node('S');
        System.out.println(naiveApproach(head));
        System.out.println(efficientApproach(head));

        Node head2 = new Node('D');
        head2.next = new Node('E');
        head2.next.next = new Node('E');
        head2.next.next.next = new Node('D');
        System.out.println(naiveApproach(head2));
        System.out.println(efficientApproach(head2));
    }

    //Time complexity: O(n)
    //Auxiliary Space: O(n)
    public static boolean naiveApproach(Node head){
        Stack<Character> stack = new Stack<>();
        Node curr = head;
        while(curr!=null){
            stack.push(curr.character);
            curr=curr.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.character!=stack.pop()) break;
            curr=curr.next;
        }
        if(curr==null) return true;
        return false;
    }

    //Time complexity:O(n)
    //Aux space:O(1)
    public static boolean efficientApproach(Node head){
        //Find the middle
        Node slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node middle = slow;

        //Reverse
        Node curr = slow.next;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            //null 10 20 null
            next = curr.next;//next: 20 null
            curr.next = prev;//curr.next: null 10
            prev = curr;//prev: 10 20
            curr = next;//curr: 20 null
        }

        Node revHead = prev;

        curr = head;
        while(revHead!=null){
            if(revHead.character!=head.character){
                return false;
            }
            revHead=revHead.next;
            head=head.next;
        }
        return true;
    }
}

