package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(30,32,1,1,10,60,35,50));
		System.out.println(trappedWaterNaive(arr));
		System.out.println(trappedWater(arr));
	}

	/**
	 * 
	 * @param arr
	 * @return
	 * Time complexity = Theta(n^2);
	 */
	public static int trappedWaterNaive(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i=1;i<arr.size()-1;i++) {
			//lmax and rmax check for the local maximum on
			//the left and right of the current element
			int lmax = arr.get(i);
			for(int j = 0;j<i;j++) {
				lmax = Math.max(lmax, arr.get(j));
			}
			int rmax = arr.get(i);
			for(int j = i+1;j<arr.size();j++) {
				rmax = Math.max(rmax, arr.get(j));
			}
			int curr=Math.min(lmax, rmax)-arr.get(i);
			System.out.println(i+":"+curr);
			res+=curr;
			
		}
		return res;
	}
	/**
	 * Aux Space = Theta(n) precomputed lmax and rmax array
	 * Time complexity =  Theta(n)
	 */
	public static int trappedWater(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println(arr);
		ArrayList<Integer> lmax = new ArrayList<>();
		lmax.add(arr.get(0));
		for(int j = 1;j<arr.size();j++) {
			lmax.add(Math.max(lmax.get(j-1), arr.get(j)));
		}
		System.out.println(lmax);
		ArrayList<Integer> rmax = new ArrayList<>();
		rmax.add(arr.get(arr.size()-1));
		for(int j = arr.size()-2;j>=0;j--) {
			rmax.add(Math.max(rmax.get(arr.size()-2-j), arr.get(j)));
		}
		reverse(rmax);
		System.out.println(rmax);
		for(int i=1;i<arr.size()-1;i++) {
			//lmax and rmax check for the local maximum on
			//the left and right of the current element
			int curr=Math.min(lmax.get(i), rmax.get(i))-arr.get(i);
			System.out.println(i+":"+curr);
			res+=curr;
			
		}
		return res;
	}
	private static void reverse(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		for(int i=0,j=arr.size()-1;i<j;i++,j--) {
			//System.out.println(i);
			int temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
		}
	}

}
