package com.lucky.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TwoNumberSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] {"Apple","Banana"};
		List<String> wordList = Arrays.asList(words);
		String[] wordArray = wordList.toArray(new String[wordList.size()]);
		System.out.println(wordArray[wordArray.length-1]);
		System.out.println(wordList);
		ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(1,3,5,6,4,2,9,7,8,10));
		twoSum(numList,14).forEach(pair->System.out.println("("+pair.get(0)+","+pair.get(1)+")"));
	}
	
	public static Set<ArrayList<Integer>> twoSum(ArrayList<Integer> numList, int target){
		Set<ArrayList<Integer>> returnSet = new LinkedHashSet<>();
		Set<Integer> numSet = new HashSet<>();
		for(Integer i : numList) {
			if(numSet.contains(target-i)) returnSet.add(new ArrayList<>(Arrays.asList(target-i,i)));
			numSet.add(i);
		}
		return returnSet;
	}

}
