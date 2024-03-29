package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class EvenOddSubarray {
	/**
	 * To find the maximum length even - odd subarray
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1,-2,1,-1,10,-2,5,2,7));//3
		arr = new ArrayList<>(Arrays.asList(2,4,6,8));//1
		System.out.println(maxLengthSubarray(arr));
	}

	private static int maxLengthSubarray(ArrayList<Integer> arr) {
		int maxLength = 1;
		int curr = 1;
		int twoConsecutiveSum = arr.get(0);
		for(int i=0;i<arr.size();i++) {
			twoConsecutiveSum+=arr.get(i);
			if(twoConsecutiveSum%2==1) curr++;
			else curr=1;
			maxLength=Math.max(maxLength, curr);
			twoConsecutiveSum=arr.get(i);
		}
		return maxLength;
	}

}
