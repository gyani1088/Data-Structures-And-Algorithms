package com.lucky.practice;

public class CheckKthBit {

	public static void main(String[] args) {
		System.out.println(ckeckIfKthBitIsSet(5,3));
		System.out.println(ckeckIfKthBitIsSet(5,2));
		System.out.println(ckeckIfKthBitIsSet2(5,3));
		System.out.println(ckeckIfKthBitIsSet2(5,2));

	}
	/**
	 * 
	 * @param number
	 * @param k -> Kth Bit from the right in the binary representation
	 * @return
	 */
	public static boolean ckeckIfKthBitIsSet(int number, int k) {
		if((number & (1<<(k-1)))!=0) return true;
		else return false;
	}
	
	public static boolean ckeckIfKthBitIsSet2(int number, int k) {
		if(((number>>(k-1)) & 1)==1) return true;
		else return false;
	}

}
