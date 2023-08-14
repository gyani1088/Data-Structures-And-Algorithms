package com.lucky.practice;

import java.util.*;

public class CountDistinctElementsInAWindow {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{1,4,3,4,1,3,2,1,2,4},3));
    }

    //Time complexity:O(n)
    // Aux space : O(k)
    public static List<Integer> countDistinct(int[] arr, int window){
        Map<Integer,Integer> distinct = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<window;i++){
            distinct.put(arr[i],distinct.getOrDefault(arr[i],0)+1);
        }
        list.add(distinct.size());
        for(int i=1;i+window-1<arr.length;i++){
           int numToBeRemoved = arr[i-1];
           distinct.put(numToBeRemoved,distinct.get(numToBeRemoved)-1);
           //if(distinct.get(numToBeRemoved)==0) distinct.remove(numToBeRemoved);
           distinct.remove(numToBeRemoved,0);
            distinct.put(arr[i+window-1],distinct.getOrDefault(arr[i+window-1],0)+1);
            list.add(distinct.size());
        }
        return list;
    }
}

//1,4,3,4,1,3,2,1,2,4 ,, window = 3
//    3,2,3,3,3,3,2,3