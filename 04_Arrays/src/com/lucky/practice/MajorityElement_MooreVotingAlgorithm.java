package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElement_MooreVotingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,2,5,2,2));
		System.out.println(findMajority(arr));

	}
	/**
	 * Moore's Voting Algorithm
	 * For working of the algorithm
	 * https://practice.geeksforgeeks.org/tracks/DSASP-Arrays/?batchId=154&tab=1
	 * @param arr
	 * @return one of of the indices of the majority element 
	 */
	public static int findMajority(ArrayList<Integer> arr) {
		int count = 1; int res = 0;
		//finds a candidate for the majority
		//INSIGHT: consecutive repeating numbers have greater chance for candidature
		//in many cases.
		//#2 - there must be 1 consecutive pair of nos. in even sized array
		//for a number to be majority.
		for (int i = 1; i<arr.size() ;i++) {
			if(arr.get(res)==arr.get(i)) count++;
			else count--;
			if (count==0) {
				count=1;
				res = i;
			}
		}
		System.out.println(res);
		//to check if the candidate's index res is occurring more than n/2 times
		count=0;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(res)==arr.get(i)) count++;
		}
		return (count>arr.size()/2)?res:-1;
	}

}
