package com.lucky.practice;

public class RopeCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxNoOfPieces(11,4,4,4));
	}
	/**
	 * To find the maximum number of pieces that we can create by cutting a rope of
	 * length x into pieces of length a,b,c only.
	 */

	public static int findMaxNoOfPieces(int x, int a, int b, int c) {
		// TODO Auto-generated method stub
		System.out.println("x="+x+",a="+a+",b="+b+",c="+c);
		if (x==0) return 0;
		if(x<0) return -1;
		int res = Math.max(Math.max(findMaxNoOfPieces(x-a, a,b,c),findMaxNoOfPieces(x-b, a,b,c)),findMaxNoOfPieces(x-c, a,b,c));
		if(res==-1) return -1;
		return res+1;
	}
	
}
