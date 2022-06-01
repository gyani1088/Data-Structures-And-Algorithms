package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortingBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(10,5,20,15));
		System.out.println(intList);
		Collections.sort(intList);
		System.out.println(intList);
		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList);
	}

}
