package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2));
		int[] val = findSecondLargestElement(arr);
		//int[] val2 = findLargestElement(arr);
		System.out.println("index:"+val[0]+", value:"+val[1]);
	}

	private static int[] findSecondLargestElement(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int[] returnVal = new int[2];
		if(arr.size()<2) {
			returnVal[0]=-1;
			return returnVal;
		}
		returnVal[0]=-1;
		int max=arr.get(0);
		int maxIndex = 0;
		returnVal[1]=max;
		if(arr.get(1)>max) {
			returnVal[1]=arr.get(0);
			returnVal[0]=0;
			max=arr.get(1);
			maxIndex=1;
		}
		else if(arr.get(1)<max) {
			returnVal[1]=arr.get(1);
			returnVal[0]=1;
		}
		for(int i=2;i<arr.size();i++) {
			if(arr.get(i)<returnVal[1]) continue;
			else if(arr.get(i)>returnVal[1] && arr.get(i)<max) {
				returnVal[0]=i;
				returnVal[1]=arr.get(i);
			}
			else if(arr.get(i)>max) {
				returnVal[0]=maxIndex;
				returnVal[1]=max;
				max=arr.get(i);
				maxIndex=i;
			}
		}
		return returnVal;
	}

}
