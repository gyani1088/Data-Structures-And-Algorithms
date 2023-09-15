package com.lucky.practice;

public class CountDistinctRowsBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,0,0,1},
                {1,0,0,1},
                {1,0,1,1},
                {1,1,1,1}};
        System.out.println(countDistinct(mat));
    }
    public static boolean insert(TrieNode root, int[][] mat, int row){
        TrieNode curr = root;
        boolean flag = false;
        for(int i=0;i<mat[row].length;i++){
            int index = mat[row][i];
            if(curr.child[index]==null){
                curr.child[index]=new TrieNode();
                flag=true;
            }
            curr=curr.child[index];
        }
        return flag;
    }

    //Time complexity: O(MxN)
    public static int countDistinct(int[][] mat){
        TrieNode root = new TrieNode();
        int res=0;
        for(int i=0;i<mat.length;i++){
            if(insert(root,mat,i)){
                res++;
            }
        }
        return res;
    }
    private static class TrieNode{
        TrieNode[] child = new TrieNode[2];
    }
}
