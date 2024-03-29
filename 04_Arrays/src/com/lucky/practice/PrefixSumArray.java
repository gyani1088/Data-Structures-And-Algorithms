package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PrefixSumArray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12,3,2,1,1,10,21,35,50));
		ArrayList<Integer> prefixSumArray = generatePrefixSumArray(arr);
		System.out.println(prefixSumArray);
		System.out.println(getSum(prefixSumArray, 0, 2));
		System.out.println(getSum(prefixSumArray, 2, 5));
		System.out.println(maxOccuringNumInRanges(new ArrayList<>(Arrays.asList(1,2,3)),new ArrayList<>(Arrays.asList(3,5,7))));
		System.out.println(isThreeEqualParts(new ArrayList<>(Arrays.asList(12,3,2,1,2,10,35,-20))));
		System.out.println(isThreeEqualParts2(new ArrayList<>(Arrays.asList(12,3,2,1,2,10,35,-20))));

	}
	/**
	 * To answer many queries we can use a prefix sum array pre constructed on 
	 * O(n) time and then answer the queries in O(n) time.
	 */
	public static ArrayList<Integer> generatePrefixSumArray(ArrayList<Integer> arr) {
		ArrayList<Integer> prefixSumArray = new ArrayList<>();
		prefixSumArray.add(arr.get(0));
		for(int i=1;i<arr.size();i++) {
			prefixSumArray.add(arr.get(i)+prefixSumArray.get(i-1));
		}
		return prefixSumArray;
	}
	/**
	 * Finds the sum of the subarray to be counted with
	 * lower and upper indices(both inclusive)
	 */
	public static int getSum(ArrayList<Integer> prefixSumArray, int lower,int upper) {
		if(lower==0) return prefixSumArray.get(upper);
		else return prefixSumArray.get(upper)-prefixSumArray.get(lower-1);
	}
	/**
	 * To check if an array has an equilibrium point(an element where the sum
	 * on both the sides is equal)
	 * 2 traversals of the array. O(n) time complexity. Aux space O(1)
	 */
	public static boolean isEquilibriumPresent(ArrayList<Integer> arr) {
		int sum =0 ;
		for(int i=0;i<arr.size();i++) {
			sum+=arr.get(i);
		}
		int lSum = 0; int rSum=sum;
		for(int i=0;i<arr.size();i++) {
			if(lSum==rSum-arr.get(i)) return true;
			lSum+=arr.get(i);
			rSum-=arr.get(i);
		}
		return false;
	}
	/**
	 * Tricky Question
	 * Find the maximum occuring number in the following ranges
	 */
	public static int maxOccuringNumInRanges(ArrayList<Integer> L,ArrayList<Integer> R) {
		//Assuming the ranges don't cross 1000
		int[] arr = new int[1000];
		for(int i=0;i<L.size();i++) {
			arr[L.get(i)]++;
			arr[R.get(i)+1]--;
		}
		int[] prefixedSumArray = new int[1000];
		prefixedSumArray[0]=arr[0];
		int max = arr[0];
		int res = 0;
		for(int i=1;i<1000;i++) {
			prefixedSumArray[i]=prefixedSumArray[i-1]+arr[i];
			if(max<prefixedSumArray[i]) {
				max=prefixedSumArray[i];
				res=i;
			}
		}
		return res;
	}
	/**
	 * Can an Array be divided into 3 parts of equal sum
	 */
	public static boolean isThreeEqualParts(ArrayList<Integer> arr) {
		int sum=0;
		for(int i=0;i<arr.size();i++) {
			sum+=arr.get(i);
		}
		if (sum%3!=0)return false;
		int onePartSum = sum/3;
		int lSum =0;
		int firstIndex = 0;
		for(int i=0;i<arr.size();i++) {
			lSum+=arr.get(i);
			if (lSum==onePartSum) {
				firstIndex=i;
				break;
			}
		}
		System.out.print(sum+","+firstIndex);
		//int secondIndex = arr.size()-1;
		int rSum=0;
		for(int i=arr.size()-1;i>firstIndex+1;i--) {
			if (rSum==onePartSum) {
				System.out.println(","+i);
				return true;
			}
			rSum+=arr.get(i);
		}
		
		return false;
	}
	//2
	public static boolean isThreeEqualParts2(ArrayList<Integer> arr) {
		int[] prefixedSumArray= new int[arr.size()];
		prefixedSumArray[0]=arr.get(0);
		for(int i=1;i<arr.size();i++) {
			prefixedSumArray[i]=prefixedSumArray[i-1]+arr.get(i);
		}
		if (prefixedSumArray[arr.size()-1]%3!=0) return false;
		int onePartSum = prefixedSumArray[arr.size()-1]/3;
		//int lSum =0;
		//int firstIndex = 0;
		boolean firstFlag=false;
		for(int i=0;i<prefixedSumArray.length-1;i++) {
			if(prefixedSumArray[i]==onePartSum) {
				System.out.println(i);
				firstFlag=true;
			}
			if(firstFlag && prefixedSumArray[i]==2*onePartSum) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	}
}
