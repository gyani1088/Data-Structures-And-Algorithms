package com.lucky.bst;

import java.util.Stack;

import static com.lucky.bst.Insertion.insert;

public class KthSmallestElement {
    static int count =0;
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

        printKth(root, 3);
        count=0;

        NodeWithLCount root2=null;
        root2 = insertWithLCount(root2,20);
        root2 = insertWithLCount(root2,15);
        root2 = insertWithLCount(root2,30);
        root2 = insertWithLCount(root2,40);
        root2 = insertWithLCount(root2,50);
        root2 = insertWithLCount(root2,12);
        root2 = insertWithLCount(root2,18);
        root2 = insertWithLCount(root2,35);
        root2 = insertWithLCount(root2,80);
        root2 = insertWithLCount(root2,7);

        iterativeInOrderTraversal2(root2);
        printKthEfficient(root2,1);
        printKthEfficient(root2,4);
        printKthEfficient(root2,8);
        printKthEfficient(root2,20);
    }

    //Time complexity: O(h+k)
    public static void printKth(Node root, int k){
        if(root!=null){
            printKth(root.left,k);
            count++;
            if(count==k){ System.out.println(root.key); return;}
            printKth(root.right,k);
        }
    }

    //Efficient Solution
    public static void printKthEfficient(NodeWithLCount root, int k){
        NodeWithLCount curr = root;
        while(k>0) {
            if (k - curr.lcount - 1>0 && curr.right!=null){
                k-=(curr.lcount+1);
                curr = curr.right;
            }
            else if (k - curr.lcount - 1<0 && curr.left!=null) {
                curr = curr.left;
            }
            else { System.out.println(curr.key); return;}
        }
    }


    //insertion with lcount
    public static NodeWithLCount insertWithLCount(NodeWithLCount root,int key){
        if(root==null){
            NodeWithLCount curr = new NodeWithLCount(key);
            return curr;
        }
        if(root.key<key){
            root.right = insertWithLCount(root.right,key);
        }
        else if (root.key>key){
            root.lcount++;
            root.left = insertWithLCount(root.left,key);
        }
        return root;
    }

    public static void iterativeInOrderTraversal2(NodeWithLCount root){
        Stack<NodeWithLCount> stack = new Stack<>();
        NodeWithLCount curr = root;
        while(curr!=null || stack.isEmpty()==false){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            System.out.print("("+curr.key+":"+"lcount="+curr.lcount+") ");
            curr=curr.right;
        }
        System.out.println();
    }

}

class NodeWithLCount{
    //while inserting, it keeps the count of the left hand side nodes
    int lcount;
    int key;
    NodeWithLCount left;
    NodeWithLCount right;
    public NodeWithLCount(int key) {
        this.key=key;
    }

}