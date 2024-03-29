package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SumSubsetProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setsCount(new ArrayList<>(Arrays.asList(1,2,3)),0,3));
		ArrayList<ArrayList<Integer>> outArray = 
		subsetLists(new ArrayList<>(Arrays.asList(1,2,3,-3)),0,0, new ArrayList<ArrayList<Integer>>(),new ArrayList<Integer>());
		outArray.forEach(System.out::println);
	}
	
	public static int setsCount(ArrayList<Integer> arr, int sum, int n) {
		if(n==0) return (sum==0)?1:0;
		return setsCount(arr, sum, n-1)+ setsCount(arr, sum-arr.get(n-1), n-1);
	}
	
	public static ArrayList<ArrayList<Integer>> subsetLists(ArrayList<Integer> arr, int sum, int k,ArrayList<ArrayList<Integer>> outArray, ArrayList<Integer> element) {
		if(k==arr.size()) {
			//System.out.println(sum+" "+element);
			if (sum==0) {
				outArray.add(element);
			}
			return outArray;
		}
		outArray = subsetLists(arr,sum,k+1,outArray,element);
		ArrayList<Integer> localList = new ArrayList<>(element);
		localList.add(arr.get(k));
		outArray = subsetLists(arr,sum-arr.get(k),k+1,outArray,localList);
		return outArray;
	}
	
}
