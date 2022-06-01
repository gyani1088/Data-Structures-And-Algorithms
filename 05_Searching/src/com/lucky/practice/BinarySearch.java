package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81));
		System.out.println(binarySearchIterative(arr,68));
		System.out.println(binarySearchIterative(arr,45));
		System.out.println(binarySearchRecursive(arr,68,0,arr.size()-1));
		System.out.println(binarySearchRecursive(arr,45,0,arr.size()-1));
	}
	/**
	 * Iterative binary search
	 */
	public static int binarySearchIterative(ArrayList<Integer> arr, int num) {
		int low=0; int high = arr.size()-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(num==arr.get(mid)) return mid;
			else if(num>arr.get(mid)) low=mid+1;
			else high = mid-1;
		}
		return -1;
	}
	/**
	 * Iterative overloaded
	 */
	public static int binarySearchIterative(ArrayList<Integer> arr, int num, int low, int high) {
		//int low=0; int high = arr.size()-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(num==arr.get(mid)) return mid;
			else if(num>arr.get(mid)) low=mid+1;
			else high = mid-1;
		}
		return -1;
	}
	
	/**
	 * Recursive binary search
	 */
	public static int binarySearchRecursive(ArrayList<Integer> arr, int num, int low, int high) {
			if (low>high) return -1;
			int mid = (low+high)/2;
			if(num==arr.get(mid)) return mid;
			else if(num>arr.get(mid)) return binarySearchRecursive(arr, num, mid+1, high);
			else return binarySearchRecursive(arr, num, low, mid-1);	
	}

}
