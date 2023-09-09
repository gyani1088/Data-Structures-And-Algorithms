package com.lucky.practice;

import java.util.Arrays;
import java.util.List;

/**
 * Interview question
 * */
public class BuildingMaximumBridges {
    public static void main(String[] args) {
        Pair[] pairs = {new Pair(6,2),
                new Pair(4,3),
                new Pair(2,6),
                new Pair(1,5)};
        System.out.println(getMaxBridges(pairs));
    }

    //Time complexity: O(nlogn) for sorting + O(nlogn) in case of binary search
    public static int getMaxBridges(Pair[] pairs){
        int n = pairs.length;
        Pair[] temp = new Pair[n];
        for(int i=0;i<n;i++){
            temp[i]=new Pair(pairs[i].src,pairs[i].dest);
        }
        Arrays.sort(temp,(o1, o2) -> {
            if(o1.src!=o2.src) return o1.src-o2.src;
            else return o1.dest-o2.dest;
        });
        //now the pairs are in increasing order of the source first and
        //we have to find longest increasing subseq of dest values.
        int[] lis = new int[n];
        int max = 0;

        //O(n2) can be reduced to O(nlogn) by reducing into binary search and maintaining a tail
        for(int i=0;i<n;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(temp[i].dest>temp[j].dest) lis[i]=Math.max(lis[i],1+lis[j]);
            }
            max = Math.max(max,lis[i]);
        }
        return max;
    }

    private static class Pair {
        int src;
        int dest;

        public Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}
