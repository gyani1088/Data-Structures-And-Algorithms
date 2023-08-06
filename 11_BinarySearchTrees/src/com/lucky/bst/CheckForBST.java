package com.lucky.bst;

import static com.lucky.bst.Insertion.insert;

public class CheckForBST {
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
        System.out.println(checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(checkBST(root));
        prev=Integer.MIN_VALUE;

        Node root2=new Node(20);
        root2.left =new Node(15);
        root2.right=new Node(55);
        root2.right.left=new Node(18);
        root2.right.right=new Node(70);
        TreeTraversal.inOrderTraversal(root2);
        System.out.println(checkBST(root2,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(checkBST(root2));
        prev=Integer.MIN_VALUE;
    }
    public static boolean checkBST(Node root,int min,int max){
        if (root==null)return true;
        //short circuiting
        return (root.key>min &&
                root.key<max &&
                checkBST(root.left,min,root.key) &&
                checkBST(root.right,root.key,max));

    }
    static int prev = Integer.MIN_VALUE;
    public static boolean checkBST(Node root){
        if (root==null)return true;
        if(checkBST(root.left)==false) return false;
        if(root.key<=prev) return false;
        prev=root.key;
        return checkBST(root.right);

    }
}
