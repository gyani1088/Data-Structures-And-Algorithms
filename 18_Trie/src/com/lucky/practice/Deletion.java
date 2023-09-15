package com.lucky.practice;

import static com.lucky.practice.Representation_Search_Insert.insert;
import static com.lucky.practice.Representation_Search_Insert.printAllWords;

/**
 * 1. chain of nodes to be deleted
 * 2. OR isEnd variable to be made false
 * */
public class Deletion {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root,"geek");
        insert(root,"geeks");
        insert(root,"any");
        printAllWords(root,new char[20],0);
        System.out.println("===================");
        delete(root,"geek",0);
        printAllWords(root,new char[20],0);
        System.out.println("===================");
        delete(root,"any",0);
        printAllWords(root,new char[20],0);
        System.out.println("===================");
    }
    public static TrieNode delete(TrieNode root, String str,int len){
        if(root==null) return null;
        if(str.length()==len){
            root.isEnd=false;
            if(isEmpty(root)) root=null;
            return root;
        }
        int index = str.charAt(len)-'a';
        root.child[index] = delete(root.child[index],str,len+1);
        if(isEmpty(root) && root.isEnd==false) root=null;
        return root;
    }

    private static boolean isEmpty(TrieNode root) {
        for(int i=0;i<26;i++){
            if(root.child[i]!=null) return false;
        }
        return true;
    }
}
