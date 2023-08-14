package com.lucky.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubArrayWithAGivenSum {
    public static void main(String[] args) {
        System.out.println(naiveSoln(Arrays.asList(1,4,6,9,12),10));
        System.out.println(isSubarrayPresentWithSum(Arrays.asList(1,4,6,9,12),10));
    }
    //Time Complexity: O(n2)
    //Aux space: O(1)
    public static boolean naiveSoln(List<Integer> list,int sum){
      for(int i=0;i<list.size();i++){
          int sum1 = 0;
          for(int j=i;j<list.size();j++){
              sum1+=list.get(j);
              if(sum1==sum) return true;
          }
        }
      return false;

    }

    //Time complexity: O(n)
    //Auxiliary space: O(n)
    //cumulative2 = cumulative1+sum
    public static boolean isSubarrayPresentWithSum(List<Integer> list, int sum){
        HashSet<Integer> set = new HashSet<>();
        int cumulative = 0;
        for(int i=0;i<list.size();i++){
            cumulative+=list.get(i);
            if(set.contains(cumulative-sum)) return true;
            if(set.contains(cumulative)) return true;
            set.add(cumulative);
        }
        return false;
    }
}


// 1,4,6,9,12
// 1,5,11,20,32
