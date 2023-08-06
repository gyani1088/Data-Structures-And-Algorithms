package com.lucky.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView_BottomView {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(60);
        root.right = new Node(80);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.right = new Node(100);
        root.right.left = new Node(8);

        topView(root);
        System.out.println();
        bottomView(root);
    }
    public static void topView(Node root){
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node curr = p.node;
            int hd = p.horizontalDistance;
            if(!map.containsKey(hd)) map.put(hd,curr.key);
            if(curr.left!=null) queue.add(new Pair(curr.left,p.horizontalDistance-1));
            if(curr.right!=null) queue.add(new Pair(curr.right,p.horizontalDistance+1));
        }
        map.entrySet().stream().forEach(entry->System.out.println("pos:"+entry.getKey()+",keys:"+entry.getValue()));
    }

    public static void bottomView(Node root){
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node curr = p.node;
            int hd = p.horizontalDistance;
            map.put(hd,curr.key);
            if(curr.left!=null) queue.add(new Pair(curr.left,p.horizontalDistance-1));
            if(curr.right!=null) queue.add(new Pair(curr.right,p.horizontalDistance+1));
        }
        map.entrySet().stream().forEach(entry->System.out.println("pos:"+entry.getKey()+",keys:"+entry.getValue()));
    }
}