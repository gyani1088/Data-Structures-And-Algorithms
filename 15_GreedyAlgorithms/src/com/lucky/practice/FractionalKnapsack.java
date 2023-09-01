package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FractionalKnapsack {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(
                Arrays.asList(new Item(50,600),new Item(20,500),new Item(30,400))
        );
        System.out.println(items);
        System.out.println(maximizeValue(items,70));
    }
    public static double maximizeValue(List<Item> list, int targetWeight){
        List<Item> valuePerWeightDec = list.stream()
                .sorted((i1,i2)->{
                  //  double f1 = ((double) i1.value)/i1.weight;
                   // double f2 = ((double) i2.value)/i2.weight;
                    return i1.weight*i2.value-i2.weight*i1.value;
                }).collect(Collectors.toList());
        double res = 0;
        for(int i=0;i<valuePerWeightDec.size();i++){
            if(valuePerWeightDec.get(i).weight<=targetWeight){
                res+=valuePerWeightDec.get(i).value;
                targetWeight-=valuePerWeightDec.get(i).weight;
            }
            else{
                res+=(valuePerWeightDec.get(i).value*targetWeight)/valuePerWeightDec.get(i).weight;
                return res;
            }
        }
        return res;
    }

    private static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" +
                    weight +
                    "," + value +
                    ')';
        }
    }
}
