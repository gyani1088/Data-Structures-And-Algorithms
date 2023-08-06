package com.lucky.bst;

public class Search {

    public static boolean search(Node root, int key){
        if(root==null) return false;
        if(root.key==key) return true;
        else if(key<root.key) return search(root.left,key);
        else return search(root.right,key);
    }

    //Time complexity:O(n)
    public static boolean searchIterative(Node root,int key){
        while(root!=null){
            if(root.key==key) return true;
            else if(root.key>key) root=root.left;
            else root=root.right;
        }
        return false;
    }
}
