package com.lucky.practice;

public class FindOnlyOddOccuringNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {41,51,42,41,42,44,51,51,43,43,51};
		System.out.println(findOnlyOddOccuringNumber(arr));
		
		int[] arr2 = {1,4,5,3};
		System.out.println(findTheMissingNumber(arr2, arr2.length));
	}
	
	public static int findOnlyOddOccuringNumber(int arr[]) {
		int res = 0;
		for (int i=0;i<arr.length;i++) {
			res=res^arr[i];
		}
		return res;
	}
	/**
	 * Find the number absent from 1 to n+1
	 */
	public static int findTheMissingNumber(int arr[], int n) {
		int res = 0;
		for(int i=1;i<=n+1;i++) {
			res=res^i;
			//System.out.println(res);
		}
		for(int i=0;i<arr.length;i++) {
			res=res^arr[i];
			//System.out.println(res);
		}
		return res;
	}
}
