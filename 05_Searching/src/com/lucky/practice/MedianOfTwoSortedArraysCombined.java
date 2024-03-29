package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArraysCombined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(2,32,55,63,68,77,81));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(12,33,48,50,52,66));
		System.out.println(findMedian(arr2, arr1));//smaller array first
	}
	/**
	 * Needs further analysis
	 */
	public static double findMedian(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int n1 = arr1.size(); int n2 = arr2.size();
		int begin1 = 0, end1 = n1;

		while(begin1 < end1)
		{
			int i1 = (begin1 + end1) / 2;
			int i2 = ((n1 + n2 + 1) / 2 )- i1;

			int min1 = (i1 == n1)?Integer.MAX_VALUE:arr1.get(i1);
			int max1 = (i1 == 0)?Integer.MIN_VALUE:arr1.get(i1 - 1);
			
			int min2 = (i2 == n2)?Integer.MAX_VALUE:arr2.get(i2);
			int max2 = (i2 == 0)?Integer.MIN_VALUE:arr2.get(i2 - 1);

			if(max1 <= min2 && max2 <= min1)
			{
				if((n1 + n2) % 2 == 0)
					return ((double)Math.max(max1, max2) + Math.min(min1, min2)) / 2;
				else
					return (double) Math.max(max1, max2);
			}
			else if(max1 > min2)
				end1 = i1 - 1;
			else 
				begin1 = i1 + 1;
		}
		
		return -1;
	}

}
