package com.lucky.practice;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TOH(4,'A','B','C');
	}
	
	public static void TOH(int n,char a,char b,char c) {
		//Base case
		if(n==1) {
			System.out.println("Move 1 from "+a+" to "+c);
			return;
		}
		TOH(n-1,a,c,b);
		System.out.println("Move "+n+" from "+a+" to "+c);
		TOH(n-1,b,a,c);
		
	}

}
