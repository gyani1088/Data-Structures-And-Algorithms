package com.lucky.practice;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aba";
		System.out.println(isPalindrome(str,0,str.length()-1));
	}

	public static boolean isPalindrome(String string,int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end) return true;
		return (string.charAt(start)==string.charAt(end)) &&
			isPalindrome(string, start+1, end-1);
	}
	
}
