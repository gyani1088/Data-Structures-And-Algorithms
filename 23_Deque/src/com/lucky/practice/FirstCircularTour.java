package com.lucky.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FirstCircularTour {
    public static void main(String[] args) {
        int[] petrol = {4,8,7,4};
        int distance[] = {6,5,3,5};
        System.out.println(firstCircularTour(petrol,distance));
        System.out.println(getFirstFeasibleStation(petrol,distance));
        petrol = new int[]{4,8};
        distance = new int[]{5,6};
        System.out.println(firstCircularTour(petrol,distance));
        System.out.println(getFirstFeasibleStation(petrol,distance));
        petrol = new int[]{8,9,4};
        distance = new int[]{5,10,12};
        System.out.println(firstCircularTour(petrol,distance));
        System.out.println(getFirstFeasibleStation(petrol,distance));
        petrol = new int[]{50,10,60,100};
        distance = new int[]{30,20,100,10};
        System.out.println(firstCircularTour(petrol,distance));
        System.out.println(getFirstFeasibleStation(petrol,distance));
    }

    public static int firstCircularTour(int petrol[], int distance[]){
        int n = distance.length;
        int currPetrol=0,prevPetrol=0;
        int start=0;
//        System.out.println(bal);
        for(int i=0;i<n;i++){
            currPetrol+= petrol[i]-distance[i];
            if(currPetrol<0){
                start=i+1;
                prevPetrol+=currPetrol;
                currPetrol=0;
            }
        }
        return currPetrol+prevPetrol>=0?start:-1;
    }

    //Deque solution
    public static int getFirstFeasibleStation(int[] petrol, int[] distance){
        int n = petrol.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int currPetrol=0;
        for(int i=0;i<2*n;i++) {
            currPetrol += petrol[i%n]-distance[i%n];
            deque.offerLast(i);
            if(currPetrol<0){
              while(currPetrol<0) {
                  int j = deque.pollFirst();
                  currPetrol-=(petrol[j%n]-distance[j%n]);
              }
            }
            if(deque.size()==n) return deque.getFirst();
        }

        return -1;
    }
}

// petrol -> 4   8   7   4
// dist  --> 6   5   3   5
//          -2   1   5   4
//           F   T   F   T
//              Ans