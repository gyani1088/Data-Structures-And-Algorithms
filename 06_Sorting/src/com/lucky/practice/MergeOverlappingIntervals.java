package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> arr = new ArrayList<>(Arrays.asList(
						new Interval(1,4),
						new Interval(3,5),
						new Interval(5,6),
						new Interval(7,10),
						new Interval(11,14),
						new Interval(12,13),
						new Interval(13,18)));
		System.out.println(arr);
		//arr=mergeIntervals(arr);
		int resIndex = nonOverlappingIntervalsInplace(arr);
		System.out.println(resIndex);
		System.out.println(arr);
	}
	
	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> arr) {
		Collections.sort(arr,new MyComparator());
		ArrayList<Interval> mergedIntervalsArray = new ArrayList<>();
		mergedIntervalsArray.add(arr.get(0));
		int localUpperLimit = arr.get(0).end;
		for(int i=1;i<arr.size();i++) {	
			if(arr.get(i).start<=localUpperLimit) {
				//System.out.println(i);
				localUpperLimit = Math.max(localUpperLimit, arr.get(i).end);
				mergedIntervalsArray.get(mergedIntervalsArray.size()-1).end = localUpperLimit;
			}
			else {
				mergedIntervalsArray.add(arr.get(i));
				localUpperLimit = arr.get(i).end;
			}
			//localUpperLimit = Math.max(localUpperLimit, arr.get(i).end);
		}
		return mergedIntervalsArray;
		//System.out.println(mergedIntervalsArray);
		//in-place modification/updation or arr
		/*
		 * arr.removeAll(arr); for(int i=0;i<mergedIntervalsArray.size();i++) {
		 * arr.add(mergedIntervalsArray.get(i)); }
		 */
	}
	
	public static int nonOverlappingIntervalsInplace(ArrayList<Interval> arr) {
		Collections.sort(arr, new MyComparator());
		int res = 0 ; //last index of non-overlapping intervals array
		for(int i=1;i<arr.size();i++) {
			if(arr.get(res).end>=arr.get(i).start) {
				arr.get(res).end = Math.max(arr.get(res).end, arr.get(i).end);
			}
			else {
				res++;
				arr.get(res).start= arr.get(i).start;
				arr.get(res).end= arr.get(i).end;
			}
		}
		return res;
	}
}

class Interval{
	int start; int end;
	Interval(int start,int end){
		this.start=start;
		this.end = end;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.start+","+this.end+"]";
	}
}

class MyComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start-o2.start;
	}
}