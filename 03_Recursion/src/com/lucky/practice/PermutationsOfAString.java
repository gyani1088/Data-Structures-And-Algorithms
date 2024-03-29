package com.lucky.practice;

public class PermutationsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute("ABC", 0);
	}
	
	public static void permute(String str, int i) {
		if(i==str.length()-1) {
			System.out.println(str);
			return;
		}
		for(int j = i;j<str.length();j++) {
			str = swap(str,i,j);
			//System.out.println(str);
			permute(str,i+1);
			str = swap(str,i,j);
		}
	}

	public static String swap(String str, int i, int j) {
		// TODO Auto-generated method stub
		char temp1 = str.charAt(i);
		char temp2 = str.charAt(j);
		str = new StringBuilder(str).delete(j, j+1).insert(j, temp1).delete(i,i+1).insert(i, temp2).toString();
		//System.out.println(str);
		return str;
	}


}
