package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(44,6,18,12,14,11,16,12,14,14,13));
		System.out.println(arr);
		System.out.println(kthSmallest(arr,5));
	}
	/**
	 * Also known as quick select algorithm
	 */
	public static int kthSmallest(ArrayList<Integer> arr, int k) {
		// TODO Auto-generated method stub
		int l=0,r=arr.size()-1;
		while(l<=r) {
			int p = Partition.lomutoPartition(arr, l, r);
			if (p==k-1) return arr.get(p);
			else if(p>k-1) r=p-1;
			else l = p+1;
		}
		return Integer.MAX_VALUE;
	}

}
