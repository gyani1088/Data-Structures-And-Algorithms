package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchSortedRotatedArray {
	/**
	 * Very Important
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81,-5,-2,0));
		System.out.println(binarySearch(arr,-2));//8
	}
	/**
	 * We need to move the unsorted half to to be handled in the else condition for each 
	 * of the halves.
	 * 
	 * **No of comparisons in this Binary Search is more than the normal binary search.
	 *Time complexity remains the same as that of binary search = O(log n)
	 */
	public static int binarySearch(ArrayList<Integer> arr, int num) {
		// TODO Auto-generated method stub
		int low = 0; int high = arr.size()-1;
		while (low<=high) {
			int mid = (low+high)/2;
			if(arr.get(mid)==num) return mid;
			//Left half sorted
			if(arr.get(mid)>arr.get(low)) {
				//check if num lies in the range
				if(num<arr.get(mid) && num>=arr.get(low)) {
					high = mid-1;
				}
				else low = mid + 1;
			}
			//Right half sorted
			else {
				if(num>arr.get(mid) && num<=arr.get(high)) {
					low = mid + 1;
				}
				else high= mid -1;
			}
		}
		return -1;
	}

}
