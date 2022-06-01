package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxGuests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(800,820,630,750,1000));
		ArrayList<Integer> dep = new ArrayList<Integer>(Arrays.asList(830,900,730,920,1230));
		System.out.println(maxGuests(arr, dep));
	}
	//Also works well for maximum trains at any station
	public static int maxGuests(ArrayList<Integer> arr, ArrayList<Integer> dep) {
		QuickSort.quickSort(arr, 0, arr.size()-1);
		QuickSort.quickSort(dep, 0, dep.size()-1);
		int i=1,j=0,curr=1,res=1;
		while(i<arr.size() && j<dep.size()) {
			if(arr.get(i)<=dep.get(j)) {
				curr++;
				i++;
			}
			else {
				curr--;j++;
			}
			res=Math.max(curr, res);
		}
		return res;
	}
}
