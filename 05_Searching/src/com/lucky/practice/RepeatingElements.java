package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class RepeatingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,4,3,1,0,3,3));
		System.out.println(repeatingElement(arr));//3
	}
	
	public static int repeatingElement(ArrayList<Integer> arr) {
		int slow = arr.get(0)+1;
		int fast = arr.get(0)+1;
		do {
			slow = arr.get(slow)+1;
			fast = arr.get(arr.get(fast)+1)+1;
		}while(slow!=fast);
		slow = arr.get(0)+1;
		while(slow!=fast) {
			slow = arr.get(slow)+1;
			fast = arr.get(fast)+1;
		}
		return fast-1;
	}

}
