package com.lucky.practice;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(567);
        hashSet.add(890);
        System.out.println(hashSet.contains(890));
        hashSet.stream().forEach(System.out::println);
        System.out.println(hashSet.add(123));
        System.out.println(hashSet.remove(123));
        System.out.println(hashSet.add(123));
    }
}


//add :O(1)
//remove :O(1)
//contains :O(1)
//size :O(1)
//isEmpty :O(1)