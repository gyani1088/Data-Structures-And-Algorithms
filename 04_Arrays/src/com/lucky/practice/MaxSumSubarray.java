package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumSubarray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1,-2,1,-1,10,-2,5,2));//9+3=12
		System.out.println(maxSumEfficient(arr));
	}

	private static int maxSumEfficient(ArrayList<Integer> arr) {
		int retVal=arr.get(0);
		int currMaxSum=arr.get(0);
		System.out.println(currMaxSum);
		for(int i=1;i<arr.size();i++) {
			//this will calculate the maximum sum having the
			//rightmost element as arr.get(i) in the possible
			//subarrays.
			//Either extend the previous maximum/subarray
			//or
			//start a new subarray from the current element
			currMaxSum=Math.max(currMaxSum+arr.get(i), arr.get(i));
			System.out.println(currMaxSum);
			retVal = Math.max(currMaxSum, retVal);
		}
		return retVal;
	}
	
	
	

}
