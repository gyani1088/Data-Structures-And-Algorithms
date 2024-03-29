package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxConsecutive1s {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,0,1,0,0,1,0,1,1,1,1,0));
		System.out.println(mostConsecutive1s(arr));
		System.out.println(mostConsecutiveOnes(arr));
	}

	private static int mostConsecutive1s(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i=0;i<arr.size();i++) {
			int curr = 0;
			while(arr.get(i)==1) {
				curr++;
				i++;
			}
			System.out.println(i);
			res = Math.max(curr, res);
		}
		return res;
	}
	/**
	 * Better approach
	 */
	private static int mostConsecutiveOnes(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int res = 0;
		int curr = 0;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)!=1) {
				curr = 0;
			}
			else {
				curr++;
				res = Math.max(curr, res);
			}
			
		}
		return res;
	}
	
	
	
}
