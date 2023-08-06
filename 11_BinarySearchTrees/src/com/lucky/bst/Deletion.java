package com.lucky.bst;

public class Deletion {

    public static void main(String[] args) {
        Node root=null;
        root = Insertion.insert(root,20);
        root = Insertion.insert(root,15);
        root = Insertion.insert(root,30);
        root = Insertion.insert(root,40);
        root = Insertion.insert(root,50);
        root = Insertion.insert(root,12);
        root = Insertion.insert(root,18);
        root = Insertion.insert(root,35);
        root = Insertion.insert(root,80);
        root = Insertion.insert(root,7);

        TreeTraversal.inOrderTraversal(root);
        System.out.println();
        root = deleteNode(root, 40);
        TreeTraversal.inOrderTraversal(root);

    }
    public static Node deleteNode(Node root, int x){
        if(root==null) return null;
        if(root.key>x) root.left = deleteNode(root.left, x);
        else if (root.key<x) root.right = deleteNode(root.right,x);
        else{
            //if left subtree is empty replace the node to be deleted with its right subtree
            if(root.left==null) return root.right;
            //if right subtree is empty replace the node to be deleted with its left subtree
            else if(root.right==null) return root.left;
            else {
                Node successor = getSuccessor(root);
                //replace the node to be deleted with the value of the next inOrder successor(exclusive to delete)
                root.key = successor.key;
                //remove the right subtree element with the successor key value, since it has already replaced
                //the node to be deleted.
                root.right = deleteNode(root.right, successor.key);
            }
        }
        return root;
    }

    //inorder successor of the root node, if the root node has no successor (DONT call this method)
    private static Node getSuccessor(Node root) {
        Node curr= root.right;
        while(curr!=null && curr.left!=null) curr = curr.left;
        return curr;
    }
}
