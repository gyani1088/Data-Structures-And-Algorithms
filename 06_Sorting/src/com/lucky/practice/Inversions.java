package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Inversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10,5,5,20,15,12,4));
		System.out.println(countInversions(arr));
		System.out.println(countInversions(arr,0,arr.size()-1));
		System.out.println(arr);
	}
	/**
	 * count = no. of swaps in insertion sort
	 */
	public static int countInversions(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr2 = new ArrayList<Integer>(arr);
		int count = 0;
		for(int i=1;i<arr2.size();i++) {
			int j = i;
			int key = arr2.get(j);
			while(j>0 && key<arr2.get(j-1)) {
				System.out.println("("+arr2.get(j-1)+","+key+")");
				arr2.set(j,arr2.get(j-1));
				count++;
				j--;
			}
			arr2.set(j, key);
		}
		//System.out.println(arr2);
		return count;
	}
	/*
	 * Using merge sort approach
	 */
	public static int countInversions(ArrayList<Integer> arr, int l, int r) {
		int count = 0;
		if(l<r) {
			int mid = (l+r)/2;
			count+=countInversions(arr,l,mid);
			count+=countInversions(arr,mid+1,r);
			count+=countAndMerge(arr,l,mid,r);
		}
		//System.out.println(arr2);
		return count;
	}
	
	public static int countAndMerge(ArrayList<Integer> arr, int l, int mid, int r) {
		System.out.println("l="+l+",mid="+mid+",r="+r+",arr(before)="+arr);
		int count=0;
		ArrayList<Integer> left = new ArrayList<Integer>(mid-l+1);
		ArrayList<Integer> right = new ArrayList<Integer>(r-mid);
		for(int i=l;i<=mid;i++) {
			left.add(arr.get(i));
		}
		for(int i=mid+1;i<=r;i++) {
			right.add(arr.get(i));
		}
		int i=0,j=0,k=l;
		while(i<left.size() && j<right.size()) {
			if(left.get(i)>right.get(j)) {
				arr.set(k, right.get(j));
				j++;
				k++;
				count+=(left.size()-i);
			}
			else if(left.get(i)<=right.get(j)) {
				arr.set(k, left.get(i));
				i++;
				k++;
			}

		}
		while(i<left.size()) {
			arr.set(k, left.get(i));
			i++;
			k++;
		}
		while(j<right.size()) {
			arr.set(k, right.get(j));
			j++;
			k++;
		}
		System.out.println("l="+l+",mid="+mid+",r="+r+",arr(after )="+arr+",count="+count);
		return count;
	}
	
}
