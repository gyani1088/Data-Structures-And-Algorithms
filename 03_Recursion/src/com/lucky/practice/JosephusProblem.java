package com.lucky.practice;

public class JosephusProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(survivorIndex(5, 3));
	}
	/**
	 * 
	 * @param n -> no of people in the circle
	 * @param k -> every kth person starting from the last index dies 
	 * and starting index for next iteration is pushed to the immediate next index
	 * of the last dead person.
	 * @return index of the survivor
	 */
	public static int survivorIndex(int n, int k) {
		if(n==1) return 0;
		return (survivorIndex(n-1, k) + k)%n;
	}

}
