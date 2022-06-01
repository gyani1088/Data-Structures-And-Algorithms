package com.lucky.practice;

public class PowerOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computePower(3, 5));
		System.out.println(computePowerIterative(2,11));
		System.out.println(computePowerIterativeBitwise(2,9));
	}
	/**
	 * Recursive way
	 */
	public static int computePower(int base, int exp) {
		if(exp==0) return 1;
		int temp = computePower(base,exp/2);
		temp = temp*temp;
		if(exp%2==0) return temp;
		else return base*temp;
	}
	/**
	 * Iterative way
	 * Time Complexity:O(logn)
	 * Auxiliary space: O(1)
	 */
	public static int computePowerIterative(int base, int exp) {
		int res = 1 ;
		while(exp>0) {
			if(exp%2==1) res*=base;
			base*=base; //power = 1,2,4,8,16......
			exp/=2;
		}
		return res;
	}
	
	public static int computePowerIterativeBitwise(int base, int exp) {
		int res = 1 ;
		while(exp>0) {
			if((exp & 1)==1) res*=base;
			base*=base; //power = 1,2,4,8,16......
			exp=exp>>1;
		}
		return res;
	}

}
