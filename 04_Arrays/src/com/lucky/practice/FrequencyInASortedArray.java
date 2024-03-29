package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class FrequencyInASortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,1,2,3,3,4,5,6,6,7));
		arr = new ArrayList<>(Arrays.asList(1));//1:1
		arr = new ArrayList<>(Arrays.asList(1,2,3,4));
		arr = new ArrayList<>(Arrays.asList(0,1,1,1,2,2));
		showFrequencies(arr);
	}

	public static void showFrequencies(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int curr = arr.get(0);
		int freq = 1;
		for(int i=1;i<arr.size();i++) {
			if (arr.get(i)==curr) freq++;
			else {
				System.out.println(curr+":"+freq);
				curr = arr.get(i);
				freq = 1;
			}
		}
		System.out.println(curr+":"+freq);
	}
	
	

}
