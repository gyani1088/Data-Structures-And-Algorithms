package com.lucky.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLongestSubsequence("kadbvkgsdfktrrseslk"));
		System.out.println(findLongestSubsequence("bbbaaaaaaaaaacd"));
		System.out.println(findLongestSubsequence("bacdd"));

	}
	
	public static String findLongestSubsequence(String str) {
		HashMap<Integer,ArrayList<String>> sequencesWithoutRepeatedLetters = new HashMap<>();
		HashMap<Character,Integer> map = new HashMap<>();
		int start=0;
		int maxLength=0;
		String longestWord="";
		boolean repeatFlag=false;
		for(int i=0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(ch, i);				
			}
			else {
				repeatFlag=true;
				String localMaxWord = str.substring(start,i);
				
				if (longestWord.length()<localMaxWord.length()) {
					maxLength=localMaxWord.length();
					longestWord=localMaxWord;
				}
				int deleteUptoIndex = map.get(ch);
				while(start<i && start<=deleteUptoIndex) {
					map.remove(str.charAt(start++));
				}
				map.put(ch, i);
			}
		}
		//String lastSubstring = str.substring(start);
		if (maxLength<str.substring(start).length())longestWord=str.substring(start);
		return repeatFlag?longestWord:str;
	}

}
