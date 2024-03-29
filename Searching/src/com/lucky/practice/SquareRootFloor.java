package com.lucky.practice;

public class SquareRootFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrtFloor(15));//3
		System.out.println(sqrtFloor(16));//4
		System.out.println(sqrtFloor(17));//4
	}

	public static int sqrtFloor(int num) {
		// TODO Auto-generated method stub
		int res = -1; int low = 1, high = num;
		while(low<=high) {
			int mid = (low+high)/2;
			int midSquare = mid*mid;
			if(midSquare==num) return mid;
			else if (midSquare>num) high = mid - 1;
			else {
				res = mid;
				low=mid+1;
			}
		}
		return res;
	}

}
