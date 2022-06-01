package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,0,1,2,2,0,0,3,3,4,0,4,4,0,5,0));
		moveZerosToEnd2(arr);
		System.out.println(arr);
	}

	public static void moveZerosToEnd(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int j = -1;
		for(int i=0;i<arr.size()-1;i++) {
			//System.out.println(i+","+j+":"+arr);
			if(j==-1 && arr.get(i)==0) j=i;
			if(j!=-1 && arr.get(i)!=0) {
				arr.set(j++, arr.get(i));
				arr.set(i, 0);
			}
		}
	}
	/**
	 * 
	 * Better soln
	 */
	public static void moveZerosToEnd2(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int j = 0;
		for(int i=0;i<arr.size();i++) {
			
			if(arr.get(i)!=0) {
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j++, temp);
			}
		}
	}

}
