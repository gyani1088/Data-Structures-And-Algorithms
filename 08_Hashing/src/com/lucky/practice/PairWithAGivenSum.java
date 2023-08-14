package com.lucky.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PairWithAGivenSum {
    public static void main(String[] args) {
        System.out.println(isSum(Arrays.asList(12,4,10,15,5,11),20));
    }
    public static boolean isSum(List<Integer> nums, int sum){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.size();i++){
            if(set.contains(sum-nums.get(i))) return true;
            else set.add(nums.get(i));
        }
        return false;
    }
}
