package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ChocolateDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10,32,22,4,62,63,68,100,11,77,81,2));
		System.out.println(arr);
		System.out.println(minDiff(arr,5));
	}

	public static int minDiff(ArrayList<Integer> arr, int m) {
		// TODO Auto-generated method stub
		if (m>arr.size()) return -1;
		QuickSort.quickSort(arr, 0, arr.size()-1);
		System.out.println(arr);
		int res = arr.get(m-1)-arr.get(0);
		for(int i=1;i+m-1<arr.size();i++) {
			res = Math.min(res, arr.get(i+m-1)-arr.get(i));
		}
		return res;
	}

}
