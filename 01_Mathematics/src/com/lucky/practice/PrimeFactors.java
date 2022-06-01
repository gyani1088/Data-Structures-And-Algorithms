package com.lucky.practice;

import java.util.ArrayList;

public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(primeFactors(44));
		System.out.println(primeFactors(450));
		System.out.println(primeFactorsEfficient(450));
	}
	
	public static ArrayList<Integer> primeFactors(int num){
		ArrayList<Integer> factors =new ArrayList<>();
		int temp = num;
		for(int i=2;i*i<=temp;i++) {
			while(temp%i==0) {
				factors.add(i);
				temp/=i;
			}
		}
		if(temp>1)factors.add(temp);
		return factors;
	}
	/**
	 * More efficient solution
	 */
	public static ArrayList<Integer> primeFactorsEfficient(int num){
		ArrayList<Integer> factors =new ArrayList<>();
		int temp = num;
		while(temp%2==0) {
			factors.add(2);
			temp/=2;
		}
		while(temp%3==0) {
			factors.add(3);
			temp/=3;
		}
		for(int i=5;i*i<=temp;i++) {
			while(temp%i==0) {
				factors.add(i);
				temp/=i;
			}
			while(temp%(i+2)==0) {
				factors.add(i+2);
				temp/=(i+2);
			}
		}
		if(temp>3)factors.add(temp);
		return factors;
	}
}
