package com.lucky.practice;


public class CircularLinkedList_Insert {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head,10);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtBegin(head,20);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtBegin(head,30);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtBegin(head,40);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtBeginEfficient(head,50);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtEndEfficient(head,0);
        CircularLinkedListTraversal.traversal(head);
        System.out.println("=========================");
        head = insertAtEnd(head,-10);
        CircularLinkedListTraversal.traversal(head);

        System.out.println("Insert at end:");
        DoublyLinkNode tail = null;
        tail = insertAtEnd(tail,10);
        tail = insertAtEnd(tail,20);
        tail = insertAtEnd(tail,30);
        CircularLinkedListTraversal.traversalWithTail_DLL(tail);

    }

    //Time complexity: O(n)
    public static Node insertAtBegin(Node head,int x){
        Node node = new Node(x);
        if(head==null) {
            node.next=node;
        }
        else{
            Node curr = head;
            while(curr.next!=head)
                curr=curr.next;
            curr.next = node;
            node.next = head;
        }
        return node;
    }

    //time complexity : O(1)
    public static Node insertAtBeginEfficient(Node head,int x){
        Node node = new Node(x);
        if(head==null) {
            node.next=node;
            return node;
        }
        else{
            node.next = head.next;
            head.next = node;
            //swapping elements of head and head.next
            int temp = node.data;
            node.data = head.data;
            head.data = temp;
            return head;
        }
    }


    //Insert at end time complexity: O(1)
    public static Node insertAtEndEfficient(Node head,int x){
        Node node = new Node(x);
        if(head==null){
            node.next = node;
        }
        else{
            node.next = head.next;
            head.next = node;
            //swapping elements of head and head.next i.e node
            int temp = node.data;
            node.data = head.data;
            head.data = temp;
        }
        return node;
    }

    public static Node insertAtEnd(Node head,int x){
        Node node = new Node(x);
        if(head==null){
            node.next = node;
            return node;
        }
        else{
            Node curr = head;
            while(curr.next!=head) curr = curr.next;
            node.next = head;
            curr.next = node;
            return head;
        }

    }

    public static DoublyLinkNode insertAtEnd(DoublyLinkNode tail, int x){
        DoublyLinkNode node = new DoublyLinkNode(x);
        if(tail==null){
            node.next=node;
            node.prev=node;
            return node;
        }
        else{
            node.next = tail.next;
            node.prev = tail;
            tail.next.prev = node;
            tail.next = node;
            return node;
        }
    }

}
