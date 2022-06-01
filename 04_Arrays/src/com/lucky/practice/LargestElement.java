package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,3,2,5,6,3,4,6));
		int[] val = findLargestElement(arr);
		//int[] val2 = findLargestElement(arr);
		System.out.println("index:"+val[0]+", value:"+val[1]);
	}

	private static int[] findLargestElement(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int[] returnVal = new int[2];
		if(arr.size()==0){
			returnVal[0]=-1;
			return returnVal;
		}
		returnVal[0]=0;
		returnVal[1]=arr.get(0);
		for(int i=1;i<arr.size();i++) {
			if(returnVal[1]<arr.get(i)) {
				returnVal[0]=i;
				returnVal[1]=arr.get(i);
			}
		}
		return returnVal;
	}

}
