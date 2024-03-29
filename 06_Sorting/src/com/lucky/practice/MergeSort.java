package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,8,9));
		System.out.println(arr1);
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(2,4,6,8));
		ArrayList<Integer> sortedMergedArray = mergeTwoSortedArrays(arr1,arr2);
		System.out.println(sortedMergedArray);
		arr1 = new ArrayList<Integer>(Arrays.asList(10,32,22,4,55,63,68,100,11,77,81,2));
		System.out.println(arr1);
		mergeSort(arr1, 0, arr1.size()-1);
		System.out.println(arr1);

	}

	public static ArrayList<Integer> mergeTwoSortedArrays(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> sortedCombinedList = new ArrayList<Integer>(arr1.size()+arr2.size());
		int i=0,j=0;
		while(i<arr1.size() && j<arr2.size()) {
			if(arr1.get(i)<=arr2.get(j)) {
				//System.out.println(i+","+j);
				sortedCombinedList.add(arr1.get(i));
				i++;
				}
			else if(arr1.get(i)>arr2.get(j)) {
				//System.out.println(i+","+j);
				sortedCombinedList.add(arr2.get(j));
				j++;
				}
		}
		while(i<arr1.size()) {
			sortedCombinedList.add(arr1.get(i));
			i++;
		}
		while(j<arr2.size()) {
			sortedCombinedList.add(arr2.get(j));
			j++;
		}
		return sortedCombinedList;
		
	}
	/**
	 * Time Complexity = Theta(n)
	 * Space Complexity = Theta(n) 
	 */
	public static void mergeFunction(ArrayList<Integer> arr,int low, int mid,int high) {
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		for(int i=low;i<=mid;i++) {
			left.add(arr.get(i));
		}
		for(int i=mid+1;i<=high;i++) {
			right.add(arr.get(i));
		}
		System.out.println(left+","+right);
		//arr = mergeTwoSortedArrays(left, right);
		int i=0,j=0,k=low;
		while(i<left.size() && j<right.size()) {
			if(left.get(i)<=right.get(j)) {
				arr.set(k, left.get(i));
				i++;
				k++;
			}
			else {
				arr.set(k, right.get(j));
				j++;
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
	}
	/**
	 * Merge Sort
	 * Time Complexity = Theta(nlogn)
	 */
	public static void mergeSort(ArrayList<Integer> arr,int l,int r) {
		System.out.println("l="+l+","+"r="+r);
		if(r>l) { // at least 2 elements
			int mid =(l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			mergeFunction(arr, l, mid, r);
		}
	}
	
   
}
