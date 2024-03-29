package com.lucky.practice;

public class FibonacciRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacciNthTerm(10));
		fibonacci(0,0,1,0);
		System.out.println("-----------------");
		fibonacci(1,0,1,0);
		System.out.println("-----------------");
		fibonacci(10,0,1,0);
		
	}

	private static void fibonacci(int n, int zeroth, int first, int k) {
		// TODO Auto-generated method stub
		if (n==0 && k==0) {
			System.out.println(zeroth);
		}
		else if (n==0 && k==1) {
			System.out.println(first);
		}
		else if(n==0) {
			System.out.println(zeroth);	
		}
		else {
			int temp = zeroth+first;//0+1
			System.out.println(zeroth);
			zeroth = first;//1
			first = temp;//1
			fibonacci(n-1, zeroth, first,k+1);
		}
		
	}
	
	public static int fibonacciNthTerm(int n) {
		// TODO Auto-generated method stub
		if (n<=1) return n;
		return fibonacciNthTerm(n-1)+fibonacciNthTerm(n-2);
	}

}
