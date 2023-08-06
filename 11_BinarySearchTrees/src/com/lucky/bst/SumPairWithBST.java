package com.lucky.bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import static com.lucky.bst.Insertion.insert;

public class SumPairWithBST {
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

        ArrayList<Node> inOrderList = new ArrayList<>();
        fillInOrderList(root,inOrderList);
        System.out.println(sumPair(inOrderList,68));
        System.out.println(isSumPair(root,62,new HashSet<Integer>()));
        System.out.println(isSumPair(root,88,new HashSet<Integer>()));
    }
    public static void fillInOrderList(Node root, ArrayList<Node> inOrderList){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null || stack.isEmpty()==false){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            inOrderList.add(curr);
            curr=curr.right;
        }
    }
    public static ArrayList<Integer> sumPair(ArrayList<Node> inOrderList, int sum){
        ArrayList<Integer> pair = new ArrayList<>(2);
        for(int i=0,j=inOrderList.size()-1;i<j;){
            if(inOrderList.get(i).key+inOrderList.get(j).key>sum) j--;
            else if(inOrderList.get(i).key+inOrderList.get(j).key<sum) i++;
            else {
                pair.add(inOrderList.get(i).key);
                pair.add(inOrderList.get(j).key);
                break;
            }
        }
        return pair;
    }

    //Method 2
    //Using HashSet. can work in normal binary tree also, not necessarily a BST
    public static boolean isSumPair(Node root, int sum, HashSet<Integer> set){
        if(root==null) return false;
        if(isSumPair(root.left,sum,set)==true) return true;
        if(set.contains(sum-root.key)) return true;
        else set.add(root.key);
        return isSumPair(root.right,sum,set);
    }
}
