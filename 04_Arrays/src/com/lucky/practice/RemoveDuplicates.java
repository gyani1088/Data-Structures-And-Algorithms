package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,4,4,4,5));
		//arr = new ArrayList<>(Arrays.asList(1,2,3,4));
		//removeDuplicates(arr);
		System.out.println(arr);
		System.out.println(removeDuplicates2(arr));
	}
	/**
	 * Remove Duplicates from a sorted array.
	 */

	public static void removeDuplicates(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.size()-1;i++) {
			if(arr.get(i)==arr.get(i+1)) {
				arr.remove(i+1);
				i--;
			}
		}
	}
	/**
	 * cost effective approach 
	 * @return size
	 */
	public static int removeDuplicates2(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		if (arr.size()==0) return 0;
		int i=1;
		for(int j=1;j<arr.size();j++) {
			if(arr.get(i-1)!=arr.get(j)) arr.set(i++,arr.get(j));
		}
		//int size = (arr.size()<1)?arr.size():i;
//		for(i++;i<arr.size();i++) {
//			arr.set(i,null);
//		}
		System.out.println(arr);
		return i;
	}
}
