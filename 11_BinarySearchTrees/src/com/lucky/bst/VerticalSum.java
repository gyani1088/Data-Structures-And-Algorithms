package com.lucky.bst;

import java.util.TreeMap;

public class VerticalSum {
    public static void main(String[] args) {
        Node2 root = new Node2(20);
        root.left = new Node2(60);
        root.right = new Node2(80);
        root.left.left = new Node2(4);
        root.left.right = new Node2(10);
        root.right.right = new Node2(100);
        root.right.left = new Node2(8);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        verticalSum(root,map);
        map.entrySet().stream().forEach(entry->System.out.println("pos:"+entry.getKey()+",sum:"+entry.getValue()));
    }

    public static void verticalSum(Node2 root, TreeMap<Integer,Integer> sums){
        if(root==null) return;
        if(root.left!=null) root.left.verticalPos=root.verticalPos-1;
        if(root.right!=null) root.right.verticalPos=root.verticalPos+1;
        verticalSum(root.left,sums);
        if(sums.get(root.verticalPos)!=null) sums.put(root.verticalPos,sums.get(root.verticalPos)+root.key);
        else sums.put(root.verticalPos,root.key);
        verticalSum(root.right,sums);
    }
}

class Node2{
    int verticalPos;
    int key;
    Node2 left;
    Node2 right;
    public Node2(int key) {
        this.key=key;
    }
}
