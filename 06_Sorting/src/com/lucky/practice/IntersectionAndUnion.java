package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionAndUnion {
	/**
	 * We need to print the common elements in 2 sorted arrays 
	 * and exclude duplicating the common element in the output.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,1,2,2,2,3,5,7,8,9));
		arr1 = new ArrayList<Integer>(Arrays.asList(1,1,2,2,2,3));
		System.out.println(arr1);
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(4,4,6,8,12,14,14,14));
		System.out.println(arr2);
		intersection(arr1,arr2);
		union(arr1, arr2);
	}
	/**
	 * Similar approach to merge function
	 */
	public static void intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int i =0,j=0;
		while(i<arr1.size() && j<arr2.size()) {
			if(i>0 && arr1.get(i)==arr1.get(i-1)) {
				i++;
				continue;
			}
			if(arr2.get(j)==arr1.get(i)) {
				System.out.println(arr1.get(i));
				i++;
				j++;
			}
			else if (arr1.get(i)<arr2.get(j)) i++;
			else j++;
		}
	}
	/**
	 * Similar approach to merge function
	 */
	public static void union(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int i =0,j=0;
		while(i<arr1.size() && j<arr2.size()) {
			if(i>0 && arr1.get(i)==arr1.get(i-1)) { i++;continue;}
			if(j>0 && arr2.get(j)==arr2.get(j-1)) { j++;continue;}
			if(arr2.get(j)>arr1.get(i)) {
				System.out.print(arr1.get(i)+",");
				i++;
			}
			else if(arr2.get(j)<arr1.get(i)){
				System.out.print(arr2.get(j)+",");
				j++;
			}
			else {
				System.out.print(arr1.get(i)+",");
				i++;
				j++;
			}
		}
		/**
		 * IMP: for printing the remaining elements(without duplicates)
		 * of the other array when one of them has been completely traversed
		 */
		while(i<arr1.size()) {
			if(i==0 || (i>0 && arr1.get(i)!=arr1.get(i-1))) {
				System.out.print(arr1.get(i)+",");
				}
			i++;
		}
		while(j<arr2.size()) {
			if(j==0 || (j>0 && arr2.get(j)!=arr2.get(j-1))) {
				System.out.print(arr2.get(j)+",");
			}
			j++;
		}
	}
	
}
