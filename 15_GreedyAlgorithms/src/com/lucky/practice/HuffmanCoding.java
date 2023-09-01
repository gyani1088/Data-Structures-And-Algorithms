package com.lucky.practice;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Variable length coding
 * Important for compression
 * */
public class HuffmanCoding {
    private static class Node{
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
//        char[] chars = new char[]{'a','d','e','f','x','y','z'};
//        int[] freq = new int[]{55,40,100,60,10,25,15};

        char[] chars = new char[]{'E','F','T','W','Y','A','I','N','O','S','G','P','H','B','R','V','D','K','L','Q','U','J','X','C','M','Z'};
        int[] freq = new int[]{12000,2500,9000,2000,2000,8000,8000,8000,8000,8000,1700,1700,6400,1600,6200,1200,4400,800,4000,500,3400,400,400,3000,3000,200};
        HashMap<Character,String> map = printCodes(chars,freq);
        String str = "ZEBRA";
        StringBuilder code = new StringBuilder();
        IntStream.range(0,str.length()).forEach(ch->{
            code.append(map.get(str.charAt(ch)));
        });
        System.out.println(map);
        System.out.println(code.toString());
    }
    public static HashMap<Character,String> printCodes(char[] characters,int[] freq){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.freq-n2.freq);
        for(int i=0;i<characters.length;i++){
            //add all the characters in the priority queue
            //all the characters are leaf nodes
            pq.add(new Node(characters[i],freq[i]));
        }
        while (pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();
            //Setting up the parent(root node at that moment) node for 2 nodes
            //'$' is the dummy character
            pq.add(new Node('$', left.freq+right.freq,left,right));
        }
        HashMap<Character,String> map = new HashMap<>();
        printRec(pq.peek(),map,"");

        return map;
    }

    public static void printRec(Node root, HashMap<Character,String> map, String s) {
        if(root==null) return;
        else if(root.ch!='$'){
            map.put(root.ch,s);
        }
        printRec(root.left,map,s+"0");
        printRec(root.right,map,s+"1");
    }
}
