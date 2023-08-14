package com.lucky.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayOfEqual0sAnd1s {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,0,0,0,0,0,0,0,1}));
    }
    public static int longestSubarray(int[] arr){
        int max = 0;
        int cumulative = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]==0?-1:1;
        }
        for(int i=0;i<arr.length;i++){
            cumulative+=arr[i];
            if(cumulative==0) max = i+1;
            if(!map.containsKey(cumulative))map.put(cumulative,i);
            if(map.containsKey(cumulative)) max = Math.max(max,i-map.get(cumulative));
        }
        return max;
    }
}

//-1 +1 +1 +1 -1 -1 +1 -1 -1
//-1  0  1  2  1  0  1  0 -1
//