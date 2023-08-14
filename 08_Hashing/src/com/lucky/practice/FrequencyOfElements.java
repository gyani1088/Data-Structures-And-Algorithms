package com.lucky.practice;

import java.util.*;

public class FrequencyOfElements {
    public static void main(String[] args) {
        System.out.println(frequencies(new ArrayList<>(Arrays.asList(12,7,5,14,12,0,10,14,6,7,7,5))));
    }
    public static Map<Integer,Integer> frequencies(List<Integer> array){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<array.size();i++){
            //map.put(array.get(i),map.get(array.get(i))==null?1:map.get(array.get(i))+1);
            map.put(array.get(i),map.getOrDefault(array.get(i),0)+1);
        }
        return map;
    }
}

//map.getOrDefault
