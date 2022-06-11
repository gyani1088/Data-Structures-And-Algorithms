package com.lucky.practice;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(List.of(3,-1,1,2,3,4,3,2,3,1,2));
		System.out.println(arr);
		countSort(arr,-1,4);
		System.out.println(arr);
	}
	/**
	 * NOT a comparison based sorting algorithm
	 * For small range only
	 * Stable algorithm
	 * Time Complexity = Theta(n+k)
	 * Space Complexity = Theta(n+k)
	 */
	public static void countSort(ArrayList<Integer> arr,int k) {
		int[] countArray = new int[k];
		for(int i=0;i<arr.size();i++) {
			countArray[arr.get(i)]++; //countArray index = element is incremented
		}
		//Naive, we are assigning indices and not objects in this approach
		//won't work the same for objects, as we are assigning indices as values
		
		//naiveApproach(arr, countArray);
		
		//General purpose  Efficient approach
		//**converting countArray into cumulativeCountArrray
		//for objects as well as integers
		//{0,2,3,3,1}---->{0,2,5,8,9}
		for (int i=1;i<k;i++) {
			countArray[i]=countArray[i]+countArray[i-1];
		}
		//VERY IMP: start traversing the input array from right to left
		//to keep the sorting stable
		Integer[] outList = new Integer[arr.size()];
		for(int i = arr.size()-1;i>=0;i--) {
			outList[countArray[arr.get(i)]-1]=arr.get(i);
			System.out.println("index="+(countArray[arr.get(i)]-1)+":value="+arr.get(i));
			countArray[arr.get(i)]--;
			
		}
		for(int i=0;i<arr.size();i++) {
			arr.set(i, outList[i]);
		}
		
	}
	/**
	 * @param arr ->size of the array
	 * @param min ->min in the input array
	 * @param max ->max in the input array
	 */
	public static void countSort(ArrayList<Integer> arr,int min,int max) {
		int k = max-min+1;
		int[] countArray = new int[k];
		for(int i=0;i<arr.size();i++) {
			countArray[arr.get(i)-min]++; //countArray index = element is incremented
		}
		for (int i=1;i<k;i++) {
			countArray[i]=countArray[i]+countArray[i-1];
		}
		//VERY IMP: start traversing the input array from right to left
		//to keep the sorting stable
		Integer[] outList = new Integer[arr.size()];
		for(int i = arr.size()-1;i>=0;i--) {
			outList[countArray[arr.get(i)-min]-1]=arr.get(i);
			//System.out.println("index="+(countArray[arr.get(i)]-1)+":value="+arr.get(i));
			countArray[arr.get(i)-min]--;
			
		}
		for(int i=0;i<arr.size();i++) {
			arr.set(i, outList[i]);
		}
		
	}
	
	private static void naiveApproach(ArrayList<Integer> arr,int[] countArray) {
		int index = 0;
		for(int i=0;i<countArray.length;i++) {
			for(int j=0;j<countArray[i];j++) {
				arr.set(index, i); // assigning indices as values
				index++;
			}
		}
	}
}
