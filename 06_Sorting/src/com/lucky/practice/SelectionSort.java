package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10,32,22,4,55,63,68,100,11,77,81,2));
		selectionSort(arr);
		System.out.println(arr);
		arr = new ArrayList<Integer>(Arrays.asList(10,32,22,4,55,63,68,100,11,77,81,2));
		selectionSort2(arr);
		System.out.println(arr);
	}
	/**
	 * Time Complexity: Theta(n^2)
	 */
	public static void selectionSort(ArrayList<Integer> arr) {
		for(int i =arr.size()-1;i>0;i--) {
			//int max = arr.get(0);
			int maxIndex = 0;
			for(int j = 1;j<=i;j++) {
				if(arr.get(maxIndex)<arr.get(j)) {
					//max=arr.get(j);
					maxIndex = j;
				}
			}
			if (i!=maxIndex)
			{
			int temp = arr.get(i);
			arr.set(i,arr.get(maxIndex));
			arr.set(maxIndex,temp);
			}
		}
	}
	/**
	 * Find the minimum and swap it with the ith index
	 * Time complexity = Theta(n^2) always. No best case could make it better
	 */
	public static void selectionSort2(ArrayList<Integer> arr) {
		for(int i =0;i<arr.size()-1;i++) {
			//int min = arr.get(i);
			int minIndex = i;
			for(int j = i+1;j<arr.size();j++) {
				if(arr.get(minIndex)>arr.get(j)) {
					//min=arr.get(j);
					minIndex = j;
				}
			}
			if (i!=minIndex)
			{
			int temp = arr.get(i);
			arr.set(i,arr.get(minIndex));
			arr.set(minIndex,temp);
			}
		}
	}

}
