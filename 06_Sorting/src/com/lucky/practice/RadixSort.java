package com.lucky.practice;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(List.of(442,6,218,12,14,11,161,124,14,141,13));
		System.out.println(arr);
		radixSort(arr);
		System.out.println(arr);
		
	}
	/**
	 * Uses countingSort as subroutine
	 * Overall time complexity = Theta(d*(n+10))
	 * where d-> length of the max number
	 * and n-> no. of elements in the array
	 * 
	 * Aux Space = Theta(n+10) or n+b where b = base used
	 */
	public static void radixSort(ArrayList<Integer> arr) {
		//find the maximum number and thus it's length
		int max=arr.get(0);
		for(int i=1;i<arr.size();i++) {
			max=(max<arr.get(i))?arr.get(i):max;
		}
		for(int exp10=1;max/exp10>0;exp10=exp10*10) {
			countingSort(arr,exp10);
		}
	}
	public static void countingSort(ArrayList<Integer> arr, int exp10) {
		int[] countArray = new int[10];
		for(int i=0;i<arr.size();i++) {
			countArray[(arr.get(i)/exp10)%10]++; // checks the position of the digit and updates the index same as the digit
		}
		//cumulative count
		for(int i=1;i<10;i++) {
			countArray[i]=countArray[i]+countArray[i-1];
		}
		Integer[] outArray = new Integer[arr.size()];
		//stable sorting based on the exp10-th digit
		for(int i=arr.size()-1;i>=0;i--) {
			outArray[countArray[(arr.get(i)/exp10)%10]-1]=arr.get(i);
			countArray[(arr.get(i)/exp10)%10]--;
		}
		//Writing the result into the original array
		for(int i=0;i<arr.size();i++) {
			arr.set(i, outArray[i]);
		}
		System.out.println(arr);
	}

}
