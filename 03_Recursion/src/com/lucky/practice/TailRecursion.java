package com.lucky.practice;

public class TailRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(4,1));
	}
	
	/**
	 * Tail recursive factorial function
	 */
	public static int fact(int i, int j) {
		// TODO Auto-generated method stub
		if(i==0||i==1) return j;
		return fact(i-1,j*i);
	}

}
