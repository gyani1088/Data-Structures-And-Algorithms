package com.lucky.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        System.out.println(isZeroSumSubArrayPresent(Arrays.asList(-3,4,-1,-3,1)));
        System.out.println(isZeroSumSubArrayPresent(Arrays.asList(-3,4,0,-3,1)));
        System.out.println(isZeroSumSubArrayPresent(Arrays.asList(-3,4,-5,-2,1)));
    }
    //Time complexity: O(n)
    public static boolean isZeroSumSubArrayPresent(List<Integer> numList){
        HashSet<Integer> set = new HashSet<>();
        if(numList.size()==0)return false;
        int sum = 0;
        for(int i=0;i<numList.size();i++){
            sum+=numList.get(i);
            if(set.contains(sum)) return true;
            if(sum==0) return true;
            set.add(sum);
        }
        return false;
    }
}

//SubArray is NOT same as a SUBSET. Elements need to be in contiguous locations to be a subarray.