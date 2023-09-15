package com.lucky.practice;

import java.util.Arrays;

public class Representation_Search_Insert {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root,"geek");
        insert(root,"geeks");
        insert(root,"any");
        printAllWords(root,new char[20],0);
        System.out.println("geek = " + search(root,"geek"));
        System.out.println("gee = " + search(root,"gee"));
    }
    public static void insert(TrieNode root,String str){
        TrieNode curr = root;
        for(int i=0;i<str.length();i++){
            int index =str.charAt(i)-'a';
            if(curr.child[index]==null) curr.child[index]=new TrieNode();
            curr=curr.child[index];
        }
        curr.isEnd=true;
    }

    public static boolean search(TrieNode root,String str){
        TrieNode curr = root;
        for(int i=0;i<str.length();i++){
            int index =str.charAt(i)-'a';
            if(curr.child[index]==null) return false;
            curr=curr.child[index];
        }
        return curr.isEnd;
    }

    public static void printAllWords(TrieNode root,char[] str,int depth){
        if(root.isEnd==true){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<depth;i++){
                sb.append(str[i]);
            }
            System.out.println(sb.toString());
            sb=null;
        }
        for(int i=0;i<26;i++){
            if(root.child[i]!=null){
                str[depth]=(char)(i+'a');
                printAllWords(root.child[i],str,depth+1);
            }
        }
    }

}
