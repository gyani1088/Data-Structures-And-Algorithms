package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumDifferenceProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,2,1,1,10,21,35,50,-6,10,5,6,3,5,2));//5
		//arr = new ArrayList<>(Arrays.asList(30,20,15));//-5
		System.out.println(maximumDifferenceProblemNaive(arr));
		System.out.println(maximumDifferenceProblem(arr));
	}

	public static int maximumDifferenceProblem(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int diff =arr.get(1)-arr.get(0);
		int minVal = arr.get(0);
		for(int j=1;j<arr.size();j++) {
			diff =  Math.max(diff, arr.get(j)-minVal);
			minVal = Math.min(minVal, arr.get(j));
			System.out.println(diff+","+minVal);
		}
		return diff;
	}
	
	public static int maximumDifferenceProblemNaive(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int diff =arr.get(1)-arr.get(0);
		for(int i=0;i<arr.size()-1;i++) {
			for(int j=i+1;j<arr.size();j++) {
				diff = Math.max(diff,arr.get(j)-arr.get(i));
			}
			
		}
		return diff;
	}
	
}
