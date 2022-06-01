package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumConsecutiveFlips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Given a binary array, we need to find how many minimum flips that it need
		 * to take to print an array of all 1s or all 0s. A flip can consist of all 
		 * consecutive 0s or 1s.
		 */
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,0,0,1,1,0,0,1,1,0));
		minimumConsecutiveFlips(arr);
	}

	public static void minimumConsecutiveFlips(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int i = 1;
		boolean flip = false;
		for(;i<arr.size();i++) {
			if (arr.get(i)!=arr.get(i-1)) {
				if (!flip) {
					flip = true;
					System.out.print("From "+i);
				}
				else 
				{
					flip=false;
					System.out.println(" to "+(i-1));
				}
			}
		}
		if(flip)System.out.println(" to "+(i-1));
		
	}
	
	
}
