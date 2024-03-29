package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81));
		System.out.println(searchIndex(arr,63));//3
		System.out.println(searchIndex(arr,15));//-1
		
		//Unbounded binary search
		System.out.println(searchIndexEfficient(arr,63));//3
		System.out.println(searchIndexEfficient(arr,15));//-1
	}
	
	/**
	 * Naive search; Time Complexity : o(pos)
	 */
	public static int searchIndex(ArrayList<Integer> arr, int num) {
		int i =0;
		while(true) {
			if (arr.get(i)==num) return i;
			if (arr.get(i)>num) break;
			i++;
		}
		//System.out.println(i);
		return -1;
	}
	/**
	 * UNBOUNDED BINARY SEARCH
	 * Efficient Solution using binary search (incrementally & divide and conquer)
	 * Time Complexity : log(pos) + log(pos) = 2log(pos)
	 */
	public static int searchIndexEfficient(ArrayList<Integer> arr, int num) {
		if(arr.get(0)==num) return 0;
		int i = 1;
		while(arr.get(i)<num) {
			i*=2;
			if (arr.get(i)==num) return i;
		}
		return BinarySearch.binarySearchIterative(arr, num,(i/2)+1,i);
	}
}
