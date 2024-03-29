package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeftRotate {
	//LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
	//HashMap<Integer,Integer> lhm = new HashMap<>(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,4,4,5));
		leftRotate(arr,3);
		System.out.println(arr);
		arr = new ArrayList<>(Arrays.asList(1,2,4,4,5));
		leftRotateUsingReverse(arr,3);
		System.out.println(arr);
	}

	public static void leftRotate(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		Integer temp = null;
		if(arr.size()>=1) temp=arr.get(0);
		int i=1;
		for(;i<arr.size();i++) {
			arr.set(i-1, arr.get(i));
		}
		arr.set(i-1, temp);
	}
	/**
	 * 
	 * @param arr
	 * @param d
	 * 
	 * Time complexity = Theta(n);
	 * Aux Space = Theta(d%n);
	 */
	public static void leftRotate(ArrayList<Integer> arr, int d) {
		// TODO Auto-generated method stub
		d%=arr.size();
		ArrayList<Integer> tempArr = new ArrayList<>();
		for(int j=0;j<d;j++) {
			tempArr.add(arr.get(j));
		}	
		int i=d;
		//int j=0;
		for(;i<arr.size();i++) {
			arr.set(i-d, arr.get(i));
		}
		for(i=0;i<d;i++) {
			arr.set(arr.size()-d+i, tempArr.get(i));
		}
		
	}
	
	/**
	 * 
	 * @param arr
	 * @param d
	 * 
	 * Time complexity = Theta(n);
	 * Aux Space = Theta(1);
	 */
	public static void leftRotateUsingReverse(ArrayList<Integer> arr, int d) {
		// TODO Auto-generated method stub
		int n = arr.size();
		d%=n;
		reverse(arr,0,d-1);
		reverse(arr,d,n-1);
		reverse(arr,0,n-1);
	}

	private static void reverse(ArrayList<Integer> arr, int low, int high) {
		// TODO Auto-generated method stub
		for(;low<high;low++,high--) {
			int temp = arr.get(low);
			arr.set(low, arr.get(high));
			arr.set(high, temp);
		}
	}
	
}
