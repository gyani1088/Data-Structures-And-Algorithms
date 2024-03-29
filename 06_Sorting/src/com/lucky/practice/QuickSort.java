package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(44,6,18,12,14,11,16,12,14,14,13));
		System.out.println(arr);
		//System.out.println(Partition.hoarePartition(arr,0,arr.size()-1));
		//quickSort(arr,0,arr.size()-1);
		quickSortLomuto(arr, 0, arr.size()-1);
		System.out.println(arr);
	}
	/**
	 * Using Hoare's partition
	 */
	public static void quickSort(ArrayList<Integer> arr,int l,int r) {
		if(l<r) {
			int p = Partition.hoarePartition(arr, l, r);
			quickSort(arr,l,p);
			quickSort(arr,p+1,r);
		}
		
	}
	
	public static void quickSortLomuto(ArrayList<Integer> arr,int l,int r) {
		if(l<r) {
			int p = Partition.lomutoPartition(arr, l, r);
			quickSort(arr,l,p-1);
			quickSort(arr,p+1,r);
		}
		
	}
	/*
	 * Tail recursive code
	 * 
	public static void quickSortTailRecursive(ArrayList<Integer> arr,int l,int r) {
		begin:
		if(l<r) {
			int p = Partition.hoarePartition(arr, l, r);
			quickSort(arr,l,p);
			l=p+1;
			goto begin;
		}		
	}
	*/
}
