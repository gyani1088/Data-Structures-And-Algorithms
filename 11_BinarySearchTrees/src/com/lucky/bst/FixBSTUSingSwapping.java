package com.lucky.bst;

import java.util.ArrayList;

public class FixBSTUSingSwapping {
    private static Node prev=null,first=null,second=null;
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(60);
        root.right = new Node(80);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.right = new Node(100);
        root.right.left = new Node(8);

        TreeTraversal.inOrderTraversal(root);
        System.out.println();
        fixBSTEfficient(root);
        System.out.println(first.key+":"+second.key);
        swap(first,second);
        TreeTraversal.inOrderTraversal(root);
    }

    public static void fixBST(Node root){
        //convert to inorder traversal
        ArrayList<Node> inOrderList = new ArrayList<>();
        Floor_ClosestLower.fillInOrderList(root,inOrderList);
        int prev=Integer.MIN_VALUE,first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        //two conditions: when there is one violation and other is when there are two violations
        for(int i=0;i<inOrderList.size();i++){
            if(inOrderList.get(i).key<prev){
                if(first==Integer.MAX_VALUE) first = prev;
                second=inOrderList.get(i).key;
            }
            prev=inOrderList.get(i).key;
        }

    }

    //proper solution
    public static void fixBSTEfficient(Node root){
        if(root==null) return;
        fixBSTEfficient(root.left);
        if(prev!=null && root.key<prev.key){
            if(first==null) first=prev;
            second = root;
        }
        prev = root;
        fixBSTEfficient(root.right);
    }

    public static void swap(Node node1, Node node2){
        int temp = node1.key;
        node1.key = node2.key;
        node2.key = temp;
    }
}
