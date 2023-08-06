package com.lucky.bst;

import java.util.*;

public class VerticalTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(60);
        root.right = new Node(80);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.right = new Node(100);
        root.right.left = new Node(8);

        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        verticalTraversal(root,0,map);
        map.entrySet().stream().forEach(entry->System.out.println("pos:"+entry.getKey()+",keys:"+entry.getValue()));
        System.out.println();
        verticalOrder(root);
    }

    //as preOrder Traversal

    public static void verticalTraversal(Node root,int position,TreeMap<Integer, ArrayList<Integer>> map){
        if(root==null) return;
        if(map.containsKey(position))
            map.get(position).add(root.key);
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.key);
            map.put(position,list);
        }
        verticalTraversal(root.left,position-1,map);
        verticalTraversal(root.right,position+1,map);
    }

    //To maintain the order, use level order traversal(CORRECT or INTUITIVE way)
    public static void verticalOrder(Node root){
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node curr = p.node;
            if(map.containsKey(p.horizontalDistance))
                map.get(p.horizontalDistance).add(curr.key);
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.key);
                map.put(p.horizontalDistance,list);
            }
            if(curr.left!=null) queue.add(new Pair(curr.left,p.horizontalDistance-1));
            if(curr.right!=null) queue.add(new Pair(curr.right,p.horizontalDistance+1));
        }
        map.entrySet().stream().forEach(entry->System.out.println("pos:"+entry.getKey()+",keys:"+entry.getValue()));
    }
}

class Pair{
    Node node;
    int horizontalDistance;

    public Pair(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
