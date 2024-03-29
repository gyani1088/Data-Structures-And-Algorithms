package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstOccurrenceInSorted {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,55,55,55,55,63,68,77,81));
		System.out.println(firstOccurrenceRecursive(arr,55,0,arr.size()-1));//2
		System.out.println(firstOccurrenceRecursive(arr,2,0,arr.size()-1));//0
		System.out.println(firstOccurrenceIterative(arr,55));//2
		System.out.println(firstOccurrenceIterative(arr,2));//0
		System.out.println(firstOccurrenceIterative(arr,44));//-1
		
		//Last occurrence
		System.out.println(lastOccurrenceIterative(arr,55));//6
		System.out.println(lastOccurrenceIterative(arr,81));//10
		System.out.println(lastOccurrenceNaive(arr,31));//-1
	}

	public static int firstOccurrenceRecursive(ArrayList<Integer> arr, int num, int low, int high) {
		if (low>high) return -1;
		int mid = (low+high)/2;
		if (num<arr.get(mid)) return firstOccurrenceRecursive(arr, num, low, mid-1);
		else if(num>arr.get(mid)) return firstOccurrenceRecursive(arr, num, mid+1, high);
		else{
			if(mid==0) return 0;
			else if(arr.get(mid)==arr.get(mid-1)) return firstOccurrenceRecursive(arr, num, low, mid-1);
			else return mid;
		}
	}
	
	public static int firstOccurrenceIterative(ArrayList<Integer> arr, int num) {
		int low=0; int high=arr.size()-1;
		while(low<=high) {
		int mid = (low+high)/2;
		if (num<arr.get(mid)) high=mid-1;
		else if(num>arr.get(mid)) low=mid+1;
		else{
			if(mid==0) return 0;
			else if(arr.get(mid)==arr.get(mid-1)) high=mid-1;
			else return mid;
		}
		}
		return -1;
	}
	/**
	 * Similarly we can use for last occurrence
	 */
	public static int lastOccurrenceIterative(ArrayList<Integer> arr, int num) {
		int low=0; int high=arr.size()-1;
		while(low<=high) {
		int mid = (low+high)/2;
		if (num<arr.get(mid)) high=mid-1;
		else if(num>arr.get(mid)) low=mid+1;
		else{
			if(mid==arr.size()-1) return mid;
			else if(arr.get(mid)==arr.get(mid+1)) low=mid+1;
			else return mid;
		}
		}
		return -1;
	}
	/**
	 * Naive Solution
	 */
	public static int lastOccurrenceNaive(ArrayList<Integer> arr, int num) {
		for(int i=arr.size()-1;i>=0;i--) {
			if(num==arr.get(i)) return i;
			else if (num<arr.get(i)) break;
		}
		return -1;
	}
}
