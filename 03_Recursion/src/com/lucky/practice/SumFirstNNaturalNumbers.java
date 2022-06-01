package com.lucky.practice;

public class SumFirstNNaturalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumofNNumbers(5,0));
		System.out.println(sumofNNumbers2(5));
	}
	/**
	 * 	Tail - Recursive
	 *	label: if (i==0) return sum;
	 *		sum=i+sum;
	 *		i=i-1;
	 *		goto label;
	 */
	private static int sumofNNumbers(int i,int sum) {
		
		if(i==0) return sum;
		return sumofNNumbers(i-1, i+sum);
	}
	
	private static int sumofNNumbers2(int i) {
		
		if(i==0) return 0;
		return i+sumofNNumbers2(i-1);
	}

}
