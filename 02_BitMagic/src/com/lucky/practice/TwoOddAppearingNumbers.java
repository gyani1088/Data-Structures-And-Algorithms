package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoOddAppearingNumbers {

	public static void main(String[] args) {
		int[] arr = {1,2,3,3,4,4,1,5};
		System.out.println(findOddAppearingNumbers(arr,arr.length));

	}
	
	public static List<Integer> findOddAppearingNumbers(int[] arr, int n){
		int xor=0,res1=0,res2=0;
		for(int i=0;i<arr.length;i++) {
			xor=xor^arr[i];
		}
		//Find the rightmost set bit of xor
		int rigtmostSetBitNumber = xor & (~(xor-1));
		for(int i=0;i<arr.length;i++) {
			int val = rigtmostSetBitNumber & arr[i];
			if (val==0) res1=res1^arr[i];
			else res2=res2^arr[i];
		}
		return Arrays.asList(res1,res2);
	}

}
