package com.lucky.practice;

import java.util.Date;

public class TrailingZeroesInAFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long start = System.currentTimeMillis();
		//Date start = new Date();
		System.out.println(start);
		System.out.println(countTrailingZeroesForFactoial(5300550));
		Long end = System.currentTimeMillis();
		System.out.println(end);
		
		start = System.currentTimeMillis();
		System.out.println(start);
		System.out.println(countTrailingZeroesForFactoialForLoop(5300550));
		end = System.currentTimeMillis();
		System.out.println(end);
	}
	
	public static int countTrailingZeroesForFactoial(int n) {
		//int twos = 0;
		int fives = 0;
		int power = 1;
		while(Math.pow(5, power)<n) {
			fives+=(n/Math.pow(5, power++));
		}
		return fives;
	}

	public static int countTrailingZeroesForFactoialForLoop(int n) {
		//int twos = 0;
		int fives = 0;
		int power = 1;
		for(int i=5;i<=n;i=i*5) {
			fives+=(n/i);
		}
		return fives;
	}
}
