package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81));
		System.out.println(peakElement(arr));
		arr = new ArrayList<Integer>(Arrays.asList(2,32,81,55,44,63,31,68,77,23));
		System.out.println(peakElement(arr));
		arr = new ArrayList<Integer>(Arrays.asList(3,3,3,3));
		System.out.println(peakElement(arr));
	}
	/**
	 * A completely flat surface is treated as a maximum or a peak;
	 * Time complexity = O(logn)
	 */
	public static int peakElement(ArrayList<Integer> arr) {
		int low = 0; int high = arr.size() - 1;
		while(low<=high) {
			int mid = (low+high)/2;
			if((mid == 0 || arr.get(mid)>=arr.get(mid-1))
					&& (mid == arr.size()-1 || arr.get(mid+1)<=arr.get(mid))) return mid;
			if (mid>0 && arr.get(mid-1)>=arr.get(mid)) high=mid-1;
			else low=mid+1;
		}
		//unreachable return statement
		return -1;
	}

}
