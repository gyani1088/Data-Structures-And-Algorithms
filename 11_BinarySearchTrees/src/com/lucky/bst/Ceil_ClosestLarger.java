package com.lucky.bst;

public class Ceil_ClosestLarger {
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
        root = Insertion.insert(root,9);

        System.out.println(findCeilEfficient(root,32).key);
    }
    public static Node findCeilEfficient(Node root, int k){
        Node res = null;
        while(root!=null){
            if(root.key==k) return root;
            else if (root.key<k) root=root.right;
            else{
                res=root;
                root=root.left;
            }
        }
        return res;
    }
}
