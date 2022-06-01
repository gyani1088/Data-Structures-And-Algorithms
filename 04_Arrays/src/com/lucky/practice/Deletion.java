package com.lucky.practice;

import java.util.Arrays;

public class Deletion {
	public static void main(String[] args) {
		int[] arr = {12,4,52,13,6};
		System.out.println(arr);
		arr=delete(arr, 52, arr.length);
		System.out.println(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	public static int[] delete(int[] arr, int x, int length) {
		// TODO Auto-generated method stub
		int i=0;
		for(;i<length;i++) {
			if(arr[i]==x)
				break;
		}
		if(i==length) return arr;
		int[] arr2 = new int[length-1];
		for(int j=0;j<length-1;j++) {
			if(j<i)arr2[j]=arr[j];
			else arr2[j]=arr[j+1];
		}
		arr=arr2;
		System.out.println("Inside function="+arr);
		return arr;
		
	}
	
	
}

