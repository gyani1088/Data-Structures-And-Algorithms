package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(6,3,9,1,5,2));
		System.out.println(arr1);
		cycleSortWithoutDuplicates(arr1);
		System.out.println(arr1);
		arr1 = new ArrayList<Integer>(Arrays.asList(6,2,3,9,5,1,1,5,2,3,3));
	}
	/**
	 * Time Complexity : O(n2)
	 * after 1 cycle. some part of the array is already sorted
	 * (i.e some nums are already at their correct positions)
	 * 
	 */
	public static void cycleSortWithoutDuplicates(ArrayList<Integer> arr) {
		for(int currStart=0;currStart<arr.size()-1;currStart++) {
			//pos is the actual position of the currentElement in the array after sorting
			int currNum = arr.get(currStart);
			int pos=currStart;
			//We fix the position of the element in the array
			for(int i=currStart+1;i<arr.size();i++) {
				if(currNum>arr.get(i)) pos++;
			}
			//Swap currNum and number the the index pos
			int temp = currNum;
			currNum=arr.get(pos);
			arr.set(pos, temp);
			
			while(pos!=currStart) {
				pos=currStart;
				//We fix the position of the element in the array
				for(int i=currStart+1;i<arr.size();i++) {
					if(currNum>arr.get(i)) pos++;
				}
				//Swap currNum and number the the index pos
				temp = currNum;
				currNum=arr.get(pos);
				arr.set(pos, temp);
			}
		}
	}

}
