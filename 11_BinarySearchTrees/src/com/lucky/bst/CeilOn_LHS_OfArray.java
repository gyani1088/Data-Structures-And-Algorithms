package com.lucky.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class CeilOn_LHS_OfArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(10,20,45,33,28,17,44,29));
        TreeSet<Integer> set = new TreeSet<>();
        System.out.print(set+" "+list.get(0)+" ");
        Integer p = set.ceiling(list.get(0));
        System.out.println(p==null?-1+" ":p+" ");
        set.add(list.get(0));
        for(int i=1;i<list.size();i++){
            int curr = list.get(i);
            System.out.print(set+" "+curr+" ");
            Integer j = set.ceiling(curr);
            System.out.println(j==null?-1+" ":j+" ");
            set.add(list.get(i));
        }
    }
}
