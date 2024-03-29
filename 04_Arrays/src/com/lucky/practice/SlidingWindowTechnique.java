package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowTechnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1,-2,1,-1,10,-2,5,2));//13
		System.out.println(maxSumKConsecutiveElements(arr,3));
		arr = new ArrayList<>(Arrays.asList(1,2,1,10,4,1,5,2));
		System.out.println(isSubArraySumEqualTo(arr, 12));//true
		System.out.println(isSubArraySumEqualTo(arr, 15));//true
		System.out.println(isSubArraySumEqualTo(arr, 8));//false
		System.out.println(N_Bonacci(3, 8));
		System.out.println(N_Bonacci(4, 10));
	}

	private static int maxSumKConsecutiveElements(ArrayList<Integer> arr, int k) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i =0 ;i<k ;i++) {
			sum += arr.get(i);
		}
		System.out.println(sum);
		int maxSum = sum;
		for(int i = k; i<arr.size(); i++) {
			sum += (arr.get(i)-arr.get(i-k));
			System.out.println(sum);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
	/**
	 * Given an array of non-negative elements, we need to find a subArray having a
	 * sum of elements equal to a given number
	 * Can be solved by sliding window technique.
	 */
	public static boolean isSubArraySumEqualTo(ArrayList<Integer> arr , int sum) {
		//boolean isEqual = false;
		int diff = sum;
		for (int i=0,j=0;i<arr.size();i++) {
			diff-=arr.get(i);
			while(diff<0) {
				diff+=arr.get(j); 
				j++;
			}
			if(diff==0) {
				System.out.println(j+","+i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param n - N bonacci
	 * @param m - size of the array
	 */
	public static ArrayList<Integer> N_Bonacci(int n, int m) {
		ArrayList<Integer> arr = new ArrayList<>();
		int currNum = 0;
		for( int i = 0;i<n;i++) {
			if(i==n-1) {
				arr.add(1);
			}
			else arr.add(0);
			currNum+=arr.get(i);
		}
		for(int i=n;i<m;i++) {
			arr.add(currNum);//0,0,1,1,2
			currNum+=(arr.get(i)-arr.get(i-n));
		}
		return arr;
	}
	
}
