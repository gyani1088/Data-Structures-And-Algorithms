package com.lucky.practice;

import java.util.ArrayList;

public class AllDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAllDivisors(36));
		System.out.println(findAllDivisorsSorted(36));
		System.out.println(findAllDivisorsSortedElegant(36));
	}
	
	
	public static ArrayList<Integer> findAllDivisors(int number){
		ArrayList<Integer> divisors = new ArrayList<>();
		divisors.add(1);
		divisors.add(number);
		for(int i=2;i*i<=number;i++) {
			if(number%i==0) {
				divisors.add(i);
				if(i!=number/i) {
					divisors.add(number/i);
				}
				
			}
		}
		return divisors;
	}

	/**
	 * Not efficient
	 */
	public static ArrayList<Integer> findAllDivisorsSorted(int number){
		ArrayList<Integer> divisors = new ArrayList<>();
		divisors.add(1);
		divisors.add(number);
		int j=1;
		for(int i=2;i*i<=number;i++) {
			if(number%i==0) {
				if (number==i*i) {
					divisors.add(j,i);
					break;
				}
				divisors.add(j,number/i);
				divisors.add(j,i);
				j++;
			}
		}
		return divisors;
	}
	
	/**
	 * Not efficient
	 */
	public static ArrayList<Integer> findAllDivisorsSortedElegant(int number){
		ArrayList<Integer> divisors = new ArrayList<>();
		int i=1;
		for(;i*i<number;i++) {
			if(number%i==0) {
				divisors.add(i);
			}
		}
		for(;i>=1;i--) {
			if(number%i==0) {
				divisors.add(number/i);
			}
		}
		return divisors;
	}

}
