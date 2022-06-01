package com.lucky.practice;

public class LCM {

	public static void main(String[] args) {
		System.out.println(lcm(50,40));

	}
	
	public static int lcm(int a, int b) {
		int gcd = GreatestCommonDivisor.gcdRecursive(a, b);
		return a*b/gcd;
		
	}
}
