package com.lucky.practice;

public class PowerOfTwo {
	/**
	 * Assuming the number is non-negative
	 */
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));
		System.out.println(isPowerOfTwo(128));
		System.out.println(isPowerOfTwo(6));
	}
	
	public static boolean isPowerOfTwo(int num) {
		return (num!=0 && ((num&(num-1))==0));
	}

}
