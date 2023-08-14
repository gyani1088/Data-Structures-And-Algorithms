package com.lucky.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(longestSub(new int[]{3,7,8,1,9,2,4}));
    }

    //Time complexity:O(n)
    //Aux space: O(n)
    //always 2n lookups at most
    //LOOKUPS: for first elements int the subsequence = 2 falseChecks+(lengthOfSubsequence-1)
    //Other elements: 1
    public  static int longestSub(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            set.add(num);
        }
        int max = 0;
        for(int num:set){
            if(set.contains(num-1)==false){
                int curr = 1;
                while(set.contains(num+curr)){
                    curr++;
                }
                max = Math.max(max,curr);
            }
        }
        return  max;
    }
}
