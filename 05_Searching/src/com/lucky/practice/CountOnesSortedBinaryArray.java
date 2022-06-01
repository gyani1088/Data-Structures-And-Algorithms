package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOnesSortedBinaryArray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(0,0,1,1,1,1));
		System.out.println(count1s(arr));
	}

	public static int count1s(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int low = 0; int high = arr.size()-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr.get(mid)==0) low = mid+1;
			else {
				if(mid == 0 || arr.get(mid-1)==0) return arr.size() - mid;
				else high=mid-1;
			}
		}
		return 0;
	}

}
