package com.lucky.practice;

public class Powerset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPowerset("ABC", "", 0);
	}
	public static void printPowerset(String str, String current, int index) {
		if(index==str.length()) {
			System.out.println(current);
			return;
		}
		printPowerset(str, current, index+1);
		printPowerset(str, current+str.charAt(index), index+1);
	}

}
