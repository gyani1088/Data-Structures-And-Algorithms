package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10,32,22,4,55,63,68,100,11,77,81,2));
		insertionSort(arr);
		System.out.println(arr);
	}
	
	/**
	 * Stable algorithm
	 * Best case (already sorted array): Theta(n)
	 * Worst case : Theta(n^2)
	 * Time Complexity : O(n)
	 */
	public static void insertionSort(ArrayList<Integer> arr) {
		//ArrayList<Integer> sortedArray = new ArrayList<>();
		for(int i=1;i<arr.size();i++) {
			int key = arr.get(i);
			int j = i-1;
			while(j>=0 && key<arr.get(j)) {
				arr.set(j+1, arr.get(j));
				j--;
			}
			arr.set(j+1, key);
		}
		
	}

}
