package com.lucky.practice;


import java.util.ArrayList;
import java.util.Arrays;

public class MaxCircularSubarraySum {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,-2,5,2));//17
		//arr = new ArrayList<>(Arrays.asList(-5,-3));//-3 should be 0
		System.out.println(maxSumEfficientWithCircular(arr));
		
		//2nd way
		System.out.println(maxSumEfficientWithCircular2(arr));
		System.out.println(arr);
	}
	/**
	 * Kadane's algorithm
	 * @param arr
	 * @return
	 */
	private static int maxSumEfficientWithCircular(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		//int maxSumLeftIndex = 0;
		int maxSum = arr.get(0);
		int minSum = arr.get(0);
		int sum = arr.get(0);
		int currMax = arr.get(0);
		int currMin = arr.get(0);
		int n = arr.size();
		for(int i = 1; i<n;i++) {
			sum += arr.get(i);//15
			currMin = Math.min(arr.get(i), currMin+arr.get(i));
			minSum = Math.min(currMin, minSum);//-2
			currMax = Math.max(currMax+arr.get(i), arr.get(i));
			maxSum = Math.max(maxSum, currMax);//15
		}
		if (maxSum<0) return maxSum;
		maxSum = Math.max(sum-minSum, maxSum);
		return maxSum;
	}
	
	//Efficient solution (Reusing maximum subarray twice to find maxsum and minsum
	private static int KadanesAlgorithm(ArrayList<Integer> arr) {
		int retVal=arr.get(0);
		int currMaxSum=arr.get(0);
		//System.out.println(currMaxSum);
		for(int i=1;i<arr.size();i++) {
			//this will calculate the maximum sum having the
			//rightmost element as arr.get(i) in the possible
			//subarrays.
			//Either extend the previous maximum/subarray
			//or
			//start a new subarray from the current element
			currMaxSum=Math.max(currMaxSum+arr.get(i), arr.get(i));
			//System.out.println(currMaxSum);
			retVal = Math.max(currMaxSum, retVal);
		}
		return retVal;
	}
	
	private static int maxSumEfficientWithCircular2(ArrayList<Integer> arr) {
		int maxSum = KadanesAlgorithm(arr);
		if(maxSum<0) return maxSum;
		int sum = 0 ;
		for(int i=0;i<arr.size();i++) {
			sum+=arr.get(i);
			arr.set(i, -arr.get(i));
		}
		int minSum = KadanesAlgorithm(arr);
		//to return the original array :D 
		//(not needed if the array is not needed after the operation)
		for(int i=0;i<arr.size();i++) {
			sum+=arr.get(i);
			arr.set(i, -arr.get(i));
		}
		return Math.max(maxSum, minSum+sum);
	}
	
	

}
