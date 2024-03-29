package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseAnArrayWithoutAuxiliarySpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println("Original="+arr);
		reverse(arr);
		System.out.println("Reversed="+arr);
	}

	private static void reverse(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		for(int i=0,j=arr.size()-1;i<j;i++,j--) {
			//System.out.println(i);
			int temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
		}
	}

}
