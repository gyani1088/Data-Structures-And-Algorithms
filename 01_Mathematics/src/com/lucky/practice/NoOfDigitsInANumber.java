package com.lucky.practice;

public class NoOfDigitsInANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num = 5469820L;
		System.out.println(countDigit(num));
		System.out.println(countDigitRecursive(num));
		System.out.println(countDigitLogarithmically(num));
	}
	
	public static int countDigit(long num) {
		int count=0;
		while(num!=0) {
			num/=10;
			count++;
		}
		return count;
	} 
	
	//Recursive
	public static int countDigitRecursive(long num) {
		if (num==0) return 0;
		return 1+ countDigitRecursive(num/10);
	}
	
	//logarithmic
	public static int countDigitLogarithmically(long num) {
		return (int) Math.floor(Math.log10(num)+1);
	} 
}
