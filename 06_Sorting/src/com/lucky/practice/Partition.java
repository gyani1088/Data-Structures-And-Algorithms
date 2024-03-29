package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(44,6,18,12,14,11,16,12,14,14,13));
		System.out.println(arr);
		//System.out.println(partitionNaive(arr,0,arr.size()-1,arr.size()-3));
		//System.out.println(lomutoPartition(arr,0,arr.size()-1));
		//when pivot is not the last element
		//System.out.println(lomutoPartition(arr,0,arr.size()-1,5));
		System.out.println(hoarePartition(arr,0,arr.size()-1));
		System.out.println(arr);
	}
	
	/**
	 * @return last occurrence of the pivot element after partitioning
	 * such that all <= numbers come on LHS of the pivot and
	 * all > numbers come on RHS of the pivot
	 */
	public static int partitionNaive(ArrayList<Integer> arr, int l, int r, int pivot) {
		System.out.println("pivot element="+arr.get(pivot));
		ArrayList<Integer> temp = new ArrayList<Integer>(r-l+1);
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)<arr.get(pivot)) temp.add(arr.get(i));
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)==arr.get(pivot)) temp.add(arr.get(i));
		}
		int res = l+temp.size()-1; // last index of the pivot element
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)>arr.get(pivot)) temp.add(arr.get(i));
		}
		//shallow copy
		//local copy of arr local to the partiotion function is pointed
		//to a new array clone from temp, pointer to the original arr is
		//lost.
//		arr = (ArrayList<Integer>) temp.clone(); //pointer to original array is lost
//		for(int i=0;i<temp.size();i++) {
//			arr.set(i, 1); // deep copy
//		}
		//deep copy
		for(int i=0;i<temp.size();i++) {
			arr.set(i, temp.get(i));
		}
		
		System.out.println("l="+l+",r="+r+",pivot="+pivot+",arr="+arr+",res="+res);
		return res;
	}
	/**
	 * LOMUTO Partition (Unstable partitioning)
	 * @param arr
	 * @param l
	 * @param h
	 * @return
	 */
	//No need for pivot argument, arr[h] is pivot;
	public static int lomutoPartition(ArrayList<Integer> arr,int l,int h) {
		int pivot=arr.get(h);
		int i = l-1;
		for(int j=l;j<=h;j++) {
			if(arr.get(j)<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,h);
		return i+1;
	}
	public static int lomutoPartition(ArrayList<Integer> arr,int l,int h,int pivotIndex) {
		swap(arr,h,pivotIndex);
		int pivot=arr.get(h);
		int i = l-1;
		for(int j=l;j<=h;j++) {
			if(arr.get(j)<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,h);
		return i+1;
	}
	
	public static void swap(ArrayList<Integer> arr, int i,int j) {
		int temp=arr.get(j);
		arr.set(j,arr.get(i));
		arr.set(i, temp);
	}
	/**
	 * @param arr -> parent array
	 * @param l
	 * @param h
	 * @return end index of the left half(smaller than pivot element of the parent array)
	 */
	public static int hoarePartition(ArrayList<Integer> arr, int l, int h) {
		int i = l-1, j = h+1;
		int pivot = arr.get(l);
		while(true) {
			do i++;
			while(arr.get(i)<pivot);
			
			do j--;
			while(arr.get(j)>pivot);
			
			if(i>=j) return j;
			
			swap(arr,i,j);
		}
	}
	

}
