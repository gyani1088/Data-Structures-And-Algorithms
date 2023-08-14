package com.lucky.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThanNByKOccurrences {
    public static void main(String[] args) {
        System.out.println(findElements(new int[]{10,10,20,20,30,10,20,30},4));
        System.out.println(findElementsSpaceEfficient(new int[]{10,40,20,20,30,10,20,30,30,30},4));
    }


    //Time complexity : O(n)
    //Huge auxiliary space for big n
    public static List<Integer> findElements(int[] arr,int k){
        int n = arr.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<n;i++){
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
            if(freq.get(arr[i])>n/k) list.add(arr[i]);
        }
        return list;
    }

    //To better use the space , we need to maintain a list of a
    //Let the max numbers of elements possible be p
    //then p*(n/k)<=n
    //then p/k<=1
    //then p<=k
    //but p can not be k since we require more than (n/k) items ==> p must be at max k-1
    //thus we will maintain a hashMap of k-1 capacity
    //
    //Time complexity: O(nk); when k is small ~O(n)
    public static List<Integer> findElementsSpaceEfficient(int[] arr,int k){
        int n = arr.length;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if (freq.containsKey(arr[i])) freq.put(arr[i],freq.get(arr[i])+1);
            else if (freq.size()<=k-1) freq.put(arr[i],1);
            else {
                freq.entrySet().forEach((entry)->{
                    entry.setValue(entry.getValue()-1);
                    if(entry.getValue()==0) freq.remove(entry.getKey());
                });
            }
        }
        return freq.keySet().stream().filter((key)->freq.get(key)>n/k).collect(Collectors.toList());
    }
}
