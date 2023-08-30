package com.lucky.practice;

import java.util.HashMap;
import java.util.HashSet;

public class CloneLLWIthRandomPointer {
    public static void main(String[] args) {
        RandomNode head = new RandomNode(10);
        RandomNode temp1 = new RandomNode(5);
        RandomNode temp2 = new RandomNode(20);
        RandomNode temp3 = new RandomNode(15);
        RandomNode temp4 = new RandomNode(20);
        head.next = temp1;
        head.random = temp2;
        temp1.next = temp2;
        temp1.random = temp3;
        temp2.next = temp3;
        temp2.random = head;
        temp3.next = temp4;
        temp3.random = temp2;
        temp4.next = null;
        temp4.random = temp3;
        System.out.println("Original");
        for(RandomNode curr= head; curr!=null;curr=curr.next){
            System.out.println(curr.data+"(->"+((curr.next!=null)?curr.next.data:"NULL")+",~>"+((curr.random!=null)?curr.random.data:"NULL")+")");
        }
        RandomNode cloneHead = cloneNaive(head);
        System.out.println("Cloned");
        for(RandomNode curr= cloneHead; curr!=null;curr=curr.next){
            System.out.println(curr.data+"(->"+((curr.next!=null)?curr.next.data:"NULL")+",~>"+((curr.random!=null)?curr.random.data:"NULL")+")");
        }
        RandomNode cloneHead2 = cloneEfficient(cloneHead);
        System.out.println("Cloned efficiently");
        for(RandomNode curr= cloneHead2; curr!=null;curr=curr.next){
            System.out.println(curr.data+"(->"+((curr.next!=null)?curr.next.data:"NULL")+",~>"+((curr.random!=null)?curr.random.data:"NULL")+")");
        }
    }
    //Time complexity:O(n)
    //Aux space: O(n)
    public static RandomNode cloneNaive(RandomNode head){
        HashMap<RandomNode,RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        while(curr!=null){
            map.put(curr,new RandomNode(curr.data));
            curr=curr.next;
        }
        map.keySet().stream().forEach(key->{
            RandomNode node = map.get(key);
            node.next=map.get(key.next);
            node.random=map.get(key.random);
        });
        return map.get(head);
    }

    //Time complexity:O(n)
    //Aux space:O(1)
    public static RandomNode cloneEfficient(RandomNode head){
        RandomNode curr = head;
        //Insert clone nodes alternatively
        while(curr!=null){
//            RandomNode clone = new RandomNode(curr.data);
//            clone.next = curr.next;
//            curr.next = clone;
//            curr = clone.next;

            RandomNode next = curr.next;
            curr.next= new RandomNode(curr.data);
            curr.next.next = next;
            curr=next;
        }

//        for(RandomNode curr1 = head;curr1!=null;curr1=curr1.next){
//            System.out.println(curr1.data);
//        }
        //Connect clone nodes with random
        for(RandomNode curr1 = head;curr1!=null;curr1=curr1.next.next){
            curr1.next.random = (curr1.random==null)?null:curr1.random.next;
        }
        //separate original clone nodes
        RandomNode h2 = head.next;
        RandomNode clone = h2;
        for(RandomNode curr1=head;curr1!=null;curr1=curr1.next.next){
            curr1.next = curr1.next.next;
            clone.next = (clone.next==null)?null:clone.next.next;
            clone=clone.next;
        }
        return h2;
    }
}

class RandomNode{
    int data;
    RandomNode next;
    RandomNode random;

    public RandomNode(int data) {
        this.data = data;
    }
}
