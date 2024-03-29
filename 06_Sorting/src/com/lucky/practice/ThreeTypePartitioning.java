package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeTypePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0,1,2,1,0,2,2,1,1));
		sort(arr);
		System.out.println(arr);
		arr = new ArrayList<>(Arrays.asList(1,2,2,4,5,3,1,6,7,15,6));
		int pivot  = 6;
		sortAroundAPivot(arr, pivot);
		System.out.println(arr+",pivot="+pivot);
		arr = new ArrayList<>(Arrays.asList(1,2,2,4,5,3,1,6,7,15,6));
		int[] range = {2,5};
		sortAroundARange(arr, range);
		System.out.println(arr+",range=["+range[0]+","+range[1]+"]");
		
	}
	//One way is to solve using 4 traversal naive method
	//First put the LHS
	//Then the middle part
	//Then the RHS
	
	/**
	 * Dutch National Flag Algorithm
	 * Logic: 0s,1s and 2s
	 * Time Complexity: Theta(n), One traversal only
	 * Space: O(1);
	 */
	public static void sort(ArrayList<Integer> arr) {
		int low = 0,high =arr.size()-1,mid =0;
		while(mid<=high) {
			if(arr.get(mid)==0) {
				Partition.swap(arr, low, mid);
				low++;
				mid++;
			}
			else if(arr.get(mid)==2) {
				Partition.swap(arr, high, mid);
				high--;
			}
			else mid++;
		}
	}
	//Around a pivot
	public static void sortAroundAPivot(ArrayList<Integer> arr,int pivot) {
		int low = 0,high =arr.size()-1,mid =0;
		while(mid<=high) {
			if(arr.get(mid)<pivot) {
				Partition.swap(arr, low, mid);
				low++;
				mid++;
			}
			else if(arr.get(mid)>pivot) {
				Partition.swap(arr, high, mid);
				high--;
			}
			else mid++;
		}
	}
	//Around a range
	public static void sortAroundARange(ArrayList<Integer> arr,int[] range) {
		int low = 0,high =arr.size()-1,mid =0;
		while(mid<=high) {
			if(arr.get(mid)<range[0]) {
				Partition.swap(arr, low, mid);
				low++;
				mid++;
			}
			else if(arr.get(mid)>range[1]) {
				Partition.swap(arr, high, mid);
				high--;
			}
			else mid++;
		}
	}
}
