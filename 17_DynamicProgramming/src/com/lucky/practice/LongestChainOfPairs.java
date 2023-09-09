package com.lucky.practice;


import java.util.Arrays;

public class LongestChainOfPairs {
    public static void main(String[] args) {
        Pair[] pairs = {new Pair(5,24),
                new Pair(39,60),
                new Pair(15,28),
                new Pair(27,40),
                new Pair(50,90)};
        System.out.println(longestChainLength(pairs));
    }

    public static int longestChainLength(Pair[] pairs){
        int n = pairs.length;
        Pair[] temp = new Pair[n];
        for(int i=0;i<n;i++){
            temp[i] = new Pair(pairs[i].first,pairs[i].second);
        }
        Arrays.sort(temp,(o1, o2) -> {
            if(o1.first!=o2.first) return o1.first-o2.first;
            else return o1.second-o2.second;
        });
        int max=0;
        int[] lcl = new int[n];
        for(int i=0;i<n;i++){
            lcl[i]=1;
            for(int j=0;j<i;j++){
                if(pairs[i].first>pairs[j].second) lcl[i]=Math.max(lcl[i],1+lcl[j]);
            }
            max= Math.max(lcl[i],max);
        }
        return max;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
