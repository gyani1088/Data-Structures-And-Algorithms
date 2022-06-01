package com.lucky.practice;

import java.util.ArrayList;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		System.out.println(getPrimeNosLessThan(271));
	}
	
	public static ArrayList<Integer> getPrimeNosLessThan(int num){
		boolean[] arr = new boolean[num+1];
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i<=num;i++) {
			if(arr[i]==false) { 
				primes.add(i);
			for(int j=2*i;j<=num;j+=i) {
				arr[j]=true;
			}
			}
		}
		return primes;
	}
	
	/**
	 * Optimized
	 */
	public static ArrayList<Integer> getPrimeNosLessThanOptimized(int num){
		boolean[] arr = new boolean[num+1];
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i<=num;i++) {
			if(arr[i]==false) { 
				primes.add(i);
			for(int j=i*i;j<=num;j+=i) { //i*i becoz all the multiples of i till i would have been multiples of nos. less than i
				arr[j]=true;
			}
			}
		}
		return primes;
	}
	
}
