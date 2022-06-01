package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOccurrenceInSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,55,55,55,55,63,68,77,81));
		System.out.println(countOccurrence(arr,55));
	}
	/**
	 * Uses first occurrence binary search and last occurrence binary search
	 * Time complexity = O(logn) + O(logn) = O(logn)
	 */
	public static int countOccurrence(ArrayList<Integer> arr, int num) {
		// TODO Auto-generated method stub
		//firstOccurrence and LastOccurrence are already written, thus reusing them.
		int firstIndex = FirstOccurrenceInSorted.firstOccurrenceIterative(arr, num);
		if(firstIndex==-1) return 0;
		else return FirstOccurrenceInSorted.lastOccurrenceIterative(arr, num) - firstIndex + 1;
	}

}
