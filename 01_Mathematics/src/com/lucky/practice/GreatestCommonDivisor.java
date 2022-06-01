package com.lucky.practice;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateGCD(7, 30));
	}
	
	public static int calculateGCD(int a,int b) {
		if(a==b) return a;
		else if(a>b) {
			a = a+b;
			b = a-b;
			a = a-b;
		}
		while(a!=0) {
			int temp=b%a;
			b=a;
			a=temp;
		}
		return b;
	}
	
	public static int gcdRecursive(int a,int b) {
		if (b==0) return a;
		else return gcdRecursive(b, a%b);
	}

}
