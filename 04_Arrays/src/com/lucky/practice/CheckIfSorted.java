package com.lucky.practice;

import java.util.Arrays;
import java.util.List;

public class CheckIfSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkIfSorted(Arrays.asList(1,2,2,3,3,4,5,6,7)));
		System.out.println(checkIfSorted(Arrays.asList(1,2,2,3,3,4,5,6,5)));
	}

	public static boolean checkIfSorted(List<Integer> asList) {
		// TODO Auto-generated method stub
		boolean val = true;
		if (asList.size()<=1) return val;
		for(int i=0;i<asList.size()-1;i++) {
			if (asList.get(i)>asList.get(i+1)) {
				val= false;
				break;
			}
		}
		return val;
	}

}
