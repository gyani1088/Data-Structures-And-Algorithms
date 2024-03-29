package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MinDiffInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,38,32,15,22));
		System.out.println(minDiff(arr));
	}

	public static int minDiff(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		QuickSort.quickSort(arr, 0, arr.size()-1);
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.size()-1;i++) {
			min = Math.min(min,arr.get(i+1)-arr.get(i));
		}
		return min;
	}
	
}
