package com.lucky.practice;

import java.util.*;

public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(naiveSolution(Arrays.asList(1,4,6,9,12,10),10));
        System.out.println(longestSubarray(Arrays.asList(1,4,6,9,12,10),10));
    }

    public static int naiveSolution(List<Integer> list,int sum){
        int res=0;
        for(int i=0;i<list.size();i++){
            int sum1 = 0;
            for(int j=i;j<list.size();j++){
                sum1+=list.get(j);
                if(sum1==sum) res = Math.max(res,j-(i-1));
            }
        }
        return res;
    }

    public static int longestSubarray(List<Integer> list, int sum){
        Map<Integer,Integer> map = new HashMap<>();
        int cumulative=0;
        int max = 0;
        for(int i=0;i<list.size();i++){
            cumulative+=list.get(i);
            if(cumulative==sum) max=i+1;//index +1;
            if(!map.containsKey(cumulative)) map.put(cumulative,i);
            if(map.containsKey(cumulative-sum)) max=Math.max(max,i-map.get(cumulative-sum));
        }
        return max;
    }
}


//1,4,6,9,12,10 ,,,, sum=10
//(1,1) (5,2) (11,3) (20,4) (32,5) (42,6)
//            3-1=2                6-5=1