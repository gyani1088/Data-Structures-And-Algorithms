package com.lucky.practice;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        System.out.println(map.put("Three",3));
        System.out.println(map.containsKey("Two"));
        map.entrySet().stream().forEach((entry)->System.out.println(entry.getKey()+":"+entry.getValue()));
        System.out.println(map);
        System.out.println(map.get("Three"));
        System.out.println(map.get("Zero"));
    }
}

//Order of insertion is not maintained
//put :O(1)
//get :O(1)