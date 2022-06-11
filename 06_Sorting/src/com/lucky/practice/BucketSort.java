package com.lucky.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(List.of(30,40,10,80,5,12,70));
		System.out.println(arr);
		bucketSort(arr,4);
		System.out.println(arr);
	}
	/**
	 * Works well for uniform distribution(provided as input information)
	 * of elements in an array.
	 * For uniform distribution and n~k
	 * @param arr
	 * @param k -> partitions/buckets
	 */
	public static void bucketSort(ArrayList<Integer> arr, int k) {
		//find the max of the array for calculating the partition indices and ranges
		int max = arr.get(0);
		for(int i=1;i<arr.size();i++) {
			max=(max<arr.get(i))?arr.get(i):max;
		}
		max++;//so that the max value gets into one index before in the partition
		//and avoiding index out of bounds exception
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
		for(int i=0;i<k;i++)
			bucket.add(new ArrayList<>());
		//filling the buckets(partitions)
		for(int i=0;i<arr.size();i++) {
			int bucketIndex = (arr.get(i)*k)/max;
			bucket.get(bucketIndex).add(arr.get(i));
		}
		//Sort each bucket
		for(int i=0;i<k;i++) {
			Collections.sort(bucket.get(i));
		}
		int index = 0;
		for(int i=0;i<k;i++) {
			for(int j=0;j<bucket.get(i).size();j++)
				arr.set(index++, bucket.get(i).get(j));
		}
		
	}

}
