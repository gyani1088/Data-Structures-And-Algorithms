package com.lucky.practice;

import java.util.List;

public class PowerSetOfAString {

	public static void main(String[] args) {
		powerSet("ABC");
	}
	public static List<String> powerSet(String str){
		int n = str.length();
		int powerSetSize = (int)Math.pow(2, n);
		for(int i = 0;i<powerSetSize;i++) {
			for(int j=0;j<n;j++) {
				if((i&(1<<j))!=0) System.out.print(str.charAt(j));
			}
			System.out.println();
		}
		return null;
	}
}
