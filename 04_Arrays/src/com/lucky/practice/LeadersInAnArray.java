package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,6,5,6,3,5,2));//6,5,2
		arr = leadersInAnArray(arr);//6,5,2
		System.out.println(arr);
	}

	public static ArrayList<Integer> leadersInAnArray(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> retArr = new ArrayList<>();
		retArr.add(arr.get(arr.size()-1));
		for(int i=arr.size()-2;i>=0;i--) {
			if(arr.get(i)>retArr.get(0)) retArr.add(0, arr.get(i));
		}
		return retArr;
	}

}
