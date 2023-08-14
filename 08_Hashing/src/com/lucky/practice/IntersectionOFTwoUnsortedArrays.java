package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOFTwoUnsortedArrays {
    public static void main(String[] args) {
        System.out.println(intersections(Arrays.asList(10,20,30),Arrays.asList(10,30,25,40)));
    }
    public static List<Integer> intersections(List<Integer> arr1, List<Integer> arr2){
        HashSet<Integer> secondSet = new HashSet<>(arr2);
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<arr1.size();i++){
            if(secondSet.contains(arr1.get(i))) output.add(arr1.get(i));
        }
        return output;
    }
}

//to be printed in the same order in which the elements appear in the first array

//10,20,30
//10,30,25,40
//Ans: 10 30