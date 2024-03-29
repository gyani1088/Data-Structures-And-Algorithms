package com.lucky.practice;

public class BitwiseOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =3,b=6;
		/**
		 * BITWISE AND
		 */
		System.out.println(a & b);//(32-bit) 00...011 & 00...110 = 00...010 = int 2
		/**
		 * BITWISE OR
		 */
		System.out.println(a | b);//(32-bit) 00...011 | 00...110 = 00...111 = int 7
		/**
		 * BITWISE XOR
		 */
		System.out.println(a ^ b);//(32-bit) 00...011 ^ 00...110 = 00...101 = int 5
		/**
		 * BITWISE NOT
		 */
		System.out.println(~a);//(32-bit) ~00...011 = 11...100 = int -4
		/**
		 * LEFT SHIFT OPERATOR
		 */
		System.out.println(a<<b);//11<<6 = 11000000 = int 192
		System.out.println(a<<31);
		/**
		 * RIGHT SHIFT OPERATOR
		 */
		System.out.println(a>>b);//1111->111->11->1= int 1 (not round shifting)
		System.out.println(Integer.toBinaryString(((Integer.MAX_VALUE)-(Integer.MAX_VALUE>>1))<<1));
		System.out.println(((Integer.MAX_VALUE)-(Integer.MAX_VALUE>>1))<<1);
		System.out.println((~(Integer.MAX_VALUE))&1);
		/**
		 * Right shift with Rounded
		 */
		int k=b;
		//a=32;
		System.out.println(Integer.toBinaryString(a));
		while(k!=0) {
			System.out.println(Integer.toBinaryString(a&1));
			a=((a&1)==1)?(a>>1)|(~(Integer.MAX_VALUE)):(a>>1)&(Integer.MAX_VALUE);
			System.out.println(Integer.toBinaryString(a));
			k--;
		}
		System.out.println(Integer.toBinaryString((Integer.MIN_VALUE)>>5));
		
		
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE>>>5));
	}

}
