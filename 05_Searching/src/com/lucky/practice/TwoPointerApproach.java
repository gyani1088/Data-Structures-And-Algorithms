package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointerApproach {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81));
		twoSum(arr, 109);
		System.out.println(isTriplet(arr, 97));//true
		System.out.println(isTriplet(arr, 44));//false
		arr = new ArrayList<Integer>(Arrays.asList(1,3,4,5,10,11,13,15));
		System.out.println(isPythagoreanTripletPresent(arr));//true
	}
	/**
	 * Two sum(Interview Easy Question)
	 * For strictly increasing function
	 */
	public static void twoSum(ArrayList<Integer> arr, int sum) {
		int i= 0;int j=arr.size()-1; boolean flag = false;
		while(i<j) {
			int pairSum = arr.get(i)+arr.get(j);
			if(pairSum==sum) {
				System.out.println("("+arr.get(i)+","+arr.get(j)+")");
				return;
			}
			if (pairSum<sum) i++;
			if (pairSum>sum) j--;
		}
		System.out.println("No pairs found");
	}
	
	public static boolean isPair(ArrayList<Integer> arr, int sum, int i, int j) {
		while(i<j) {
			int pairSum = arr.get(i)+arr.get(j);
			if(pairSum==sum) {
				System.out.print("("+arr.get(i)+","+arr.get(j)+",");
				return true;
			}
			if (pairSum<sum) i++;
			if (pairSum>sum) j--;
		}
		return false;
	}
	/**
	 * Three sum
	 * 
	 */
	public static boolean isTriplet(ArrayList<Integer> arr, int sum){
		for(int i=0;i<arr.size()-2;i++) {
			if(isPair(arr, sum-arr.get(i), i+1, arr.size()-1)) {
				System.out.println(arr.get(i)+")");
				return true;
			}
		}
		return false;
	}
	/**
	 * Pythgorean triplet
	 */
	public static boolean isPythagoreanTripletPresent(ArrayList<Integer> arr) {
		for(int k=arr.size()-1;k>1;k--) {
			int i =0; int j= k-1;
			while(i<j) {
				if((arr.get(i)*arr.get(i))+(arr.get(j)*arr.get(j))==arr.get(k)*arr.get(k)) {
					System.out.println(arr.get(i)+","+arr.get(j)+","+arr.get(k));
					return true;
				}
				else if((arr.get(i)*arr.get(i))+(arr.get(j)*arr.get(j))<arr.get(k)*arr.get(k)) {
					//System.out.println(i);
					i++;
				}
				else { 
					//System.out.println(j);
					j--;
				
				}
			}
		}
		return false;
	}
	
}
