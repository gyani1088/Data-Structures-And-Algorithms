package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MinPagesForKPartitions {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,32,81,5,55,22));
		System.out.println(minPages(arr, arr.size(), 3));
		System.out.println(minPagesBinarySearch(arr, arr.size(), 3));
	}
	/**
	 * Recursive Approach
	 */
	public static int minPages(ArrayList<Integer> arr, int n, int k) {
		//System.out.println("n="+n+","+"k="+k);
		if(k==1) return sum(arr, 0, n-1);
		if(n==1) return arr.get(0);
		int res = Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
			//i needs to be stored as length of arr so it starts from 1
			int sum = sum(arr,i,n-1);
			int pages = minPages(arr, i, k-1);
			int temp = Math.max(pages, sum);
			//System.out.println("i="+i+","+"k="+(k-1)+",temp="+temp+",sum="+sum+",pages="+pages);
			res = Math.min(res, temp);
		}
		return res;
	}
	/**
	 * Util function
	 */
	public static int sum(ArrayList<Integer> arr, int start, int end) {
		int sum = 0;
		for(int i=start;i<=end;i++) {
			sum+=arr.get(i);
		}
		return sum;
	}
	/**
	 * Using Binary Search
	 * Time Complexity =  O(n) for feasibilityCheck and O(log(sum-max)) for binarySearch
	 *  = O(n*log(sum-max));
	 */
	public static int minPagesBinarySearch(ArrayList<Integer> arr, int n, int k) {
		//setting up the range for the return value
		//low = max(arr) , high = sum(arr)
		int max =0; int sum=0;
		for(int i=0;i<arr.size();i++) {
			max = (max<arr.get(i))?arr.get(i):max;
			sum+=arr.get(i);
		}
		int low = max; int high = sum; int res = 0;
		while(low<=high) {
			int mid = (low+high)/2;
			if(isFeasible(arr,k,mid)) {
				res = mid;
				System.out.println(res);
				high=mid-1;
			}
			else low=mid+1;
		}
		return res;
	}

	public static boolean isFeasible(ArrayList<Integer> arr, int k, int mid) {
		// TODO Auto-generated method stub
		int res = 1; int sum =0;
		for(int i =0;i<arr.size();i++) {
			sum+=arr.get(i);
			if(sum>mid) {
				res++;
				sum=arr.get(i);
			}
		}
		return (res<=k);
	}
}
