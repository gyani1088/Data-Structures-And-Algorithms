package com.lucky.practice;

import java.util.*;

/**
 * we are given a set of k digits and we need to generate the first n numbers containing only these digits
 */
public class GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        System.out.println(firstNNumbers(Arrays.asList(3,5,4),10));
    }
    public static List<String> firstNNumbers(List<Integer> digits, int n){
        Queue<String> queue = new ArrayDeque<>();
        List<String> output = new ArrayList<>();
        Collections.sort(digits);
        for(int i=0;i<digits.size();i++){
            queue.add(digits.get(i)+"");
        }
        for(int i=0;queue.size()<=n;i++){
            String front = queue.poll();
            output.add(front);
            for(int j=0;j<digits.size();j++){
                queue.add(front+digits.get(j));
            }
        }
        while(output.size()!=n){
            output.add(queue.poll());
        }
        return output;
    }
}
