package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10,32,22,4,55,63,68,100,11,77,81,2));
		arr = new ArrayList<Integer>(Arrays.asList(32,22,11));
		bubbleSort(arr);
		System.out.println(arr);
	}

	public static void bubbleSort(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		for(int i = 0;i<arr.size()-1;i++) {
			System.out.println("=="+i+"th iteration==");
			for(int j=0;j<arr.size()-i-1;j++) {
				if(arr.get(j)>arr.get(j+1)) {
					int temp = arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1,temp);
				}
				System.out.println(arr);
			}
		}
	}
	

}
