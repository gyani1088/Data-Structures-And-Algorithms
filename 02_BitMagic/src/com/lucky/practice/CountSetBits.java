package com.lucky.practice;

public class CountSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSetBits(5));
		System.out.println("Kerningham's : "+countSetBitsKerninghams(5));
		System.out.println(countSetBits(8));
		System.out.println(countSetBits(7));
		System.out.println(countSetBitsLookupTable(0xff));

	}
	
	public static int countSetBits(int number) {
		int bits =0;
		while(number!=0) {
			//if((number&1)==1) bits++;
			//OR
			bits+=(number&1);
			number=number>>1;
		}
		return bits;
	}
	
	/**
	 * Kerningham's Algorithm
	 */
	public static int countSetBitsKerninghams(int number) {
		int bits =0;
		while(number!=0) {
			number=(number&(number-1));
			bits++;
		}
		return bits;
	}
	/**
	 * For TimeComplexity O(1) --->Lookup table
	 */
	public static int countSetBitsLookupTable(int number) {
		//Lookup table
		int[] table = new int[256];
		/**
		 * Initializing the lookup table
		 */
		for(int i=1;i<=255;i++) {
			table[i] = (i&1)+table[i/2];
		}
		int res = table[number&0xff];
		number=number>>8;
		res += table[number&0xff];
		number=number>>8;
		res += table[number&0xff];
		number=number>>8;
		res += table[number&0xff];	
		return res;
		
		
	}
	
}
