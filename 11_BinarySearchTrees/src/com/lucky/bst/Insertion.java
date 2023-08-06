package com.lucky.bst;

import javax.xml.transform.Templates;

public class Insertion {

    public static void main(String[] args) {
        Node root=null;
        root = insert(root,20);
        root = insert(root,15);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,12);
        root = insert(root,18);
        root = insert(root,35);
        root = insert(root,80);
        root = insert(root,7);

        TreeTraversal.inOrderTraversal(root);

    }
    //Recursive approach
    //Time complexity: O(h)
    //Aux space: O(h)
    public static Node insert(Node root,int x){
        if(root==null) return new Node(x);
        if(root.key<x) root.right = insert(root.right,x);
        else if (root.key>x) root.left = insert(root.left,x);
        return root;
    }

    //Time complexity: O(h)
    //Aux space: O(1)
    public static Node insertIterative(Node root, int x){
        Node temp = new Node(x);
        Node parent = null, curr = root;
        //to find the parent of the target node temp
        while(curr!=null){
            parent = curr;
            if (curr.key>x) curr=curr.left;
            else if(curr.key<x) curr=curr.right;
            else return root;
        }
        if(parent==null) return temp;
        if (parent.key>x) parent.left = temp;
        else if (parent.key<x) parent.right = temp;
        return root;
    }
}
