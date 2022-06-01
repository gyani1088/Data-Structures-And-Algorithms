package com.lucky.practice;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortingBasics {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,40,23,42,15,77,73};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		arr = new int[]{15,22,21,13,24};
		Arrays.sort(arr,2,5);
		System.out.println(Arrays.toString(arr));
		Point[] arrPoints = new Point[]{new Point(2,3),new Point(3, 1),new Point(6, 0)};
		Arrays.sort(arrPoints);
		for(int i=0;i<arrPoints.length;i++) {
			System.out.println(arrPoints[i].x+","+arrPoints[i].y);
		}
		Arrays.sort(arrPoints,new PointComparator());
		for(int i=0;i<arrPoints.length;i++) {
			System.out.println(arrPoints[i].x+","+arrPoints[i].y);
		}
		Integer[] arrWrapper = {10,40,23,42,15,77,73};
		Arrays.sort(arrWrapper,new EvenOddComparator());
		System.out.println(Arrays.toString(arrWrapper));
	}
}
 class Point implements Comparable<Point>{
	 
	 int x;
	 int y;
	 public Point(int x,int y) {
		 this.x = x;
		 this.y = y;
	 }
	 
	 @Override
	public int compareTo(Point p) {
		return this.y - p.y;
	}
 }
 /**
  * Using an external comparator instead of implementing comparable
  */
class PointComparator implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		return o1.x-o2.x;
	}
}
/**
 * Using an external comparator instead of implementing comparable for wrapper classes
 */
class EvenOddComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1%2==o2%2) return o1-o2;
		else return o1%2-o2%2;
	}
}