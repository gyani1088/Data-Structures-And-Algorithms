package com.lucky.practice;

import java.math.BigInteger;

public class FactorialOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(BigInteger.valueOf(0)==BigInteger.ZERO);
		//System.out.println(calculateFactorial(7000));
		System.out.println(calculateFactorialRecursive(7));
		
	}
	
	public static BigInteger calculateFactorial(int n) {
		if (BigInteger.valueOf(n)==BigInteger.ZERO || BigInteger.valueOf(n) == BigInteger.ONE) return BigInteger.ONE;
		BigInteger factorial = BigInteger.ONE;
		for(int i=2;i<=n;i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
			//System.out.println(i);
		}
		return factorial;
	}
	/**
	 * 
	 * Recursive approach to calculate factorial of a number n
	 */
	public static int calculateFactorialRecursive(int n) {
		//Base Condition
		if(n==0 || n==1) return 1;
		return n*(calculateFactorialRecursive(n-1));
	}

}
