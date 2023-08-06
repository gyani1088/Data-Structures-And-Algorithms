package com.lucky.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Floor_ClosestLower {
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

        ArrayList<Node> inOrderList = new ArrayList<>();
        fillInOrderList(root,inOrderList);
        inOrderList.stream().forEach(i->System.out.print(i.key+" "));
        System.out.println();
        System.out.println(findFloorNaive(inOrderList,47));
        System.out.println(findFloorNaive(inOrderList,40));
        System.out.println(findFloorEfficient(root,47).key);
        System.out.println(findFloorEfficient(root,11).key);
    }
    public static void fillBFSList(Node node, ArrayList<Node> bfsList) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (queue.isEmpty() == false) {
            Node curr = queue.poll();
            bfsList.add(curr);
            //enqueing the next level
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void fillInOrderList(Node root,ArrayList<Node> inOrderList){
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

    public static Integer findFloorNaive(ArrayList<Node> bfsList,int k){
        int i=0;
        while(bfsList.get(i).key<=k){
            i++;
        }
        return (i==0)?null:bfsList.get(i-1).key;
    }


    //Efficient Solution
    public static Node findFloorEfficient(Node root, int k){
        Node res = null;
        while(root!=null){
            if(root.key==k) return root;
            else if (root.key>k) root=root.left;
            else{
                res=root;
                root=root.right;
            }
        }
        return res;
    }
}
// 10 20 30 40 ,,,, 25
//Ans 20