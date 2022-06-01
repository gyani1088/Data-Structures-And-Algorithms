package com.lucky.practice;

public class PrintNto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printInReverseOrder(5);
		printInIncOrder(5);
	}

	public static void printInReverseOrder(int i) {
		// TODO Auto-generated method stub
		if (i==0) return;
		System.out.println(i);
		printInReverseOrder(i-1);
	}
	
	public static void printInIncOrder(int i) {
		// TODO Auto-generated method stub
		if (i==0) return;
		printInIncOrder(i-1);
		System.out.println(i);
	}

}
