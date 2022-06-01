package com.lucky.practice;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(243));//false
		System.out.println(isPalindrome(2));//true
		System.out.println(isPalindrome(28882));//true
	}
	
	public static boolean isPalindrome(long num) {
		long reverse = 0;
		/**num is not directly used, instead we create temp 
		 * so that we don't disturb the original number for comparison
		 **/
		long temp = num;
		while(temp!=0) {
			long r = temp%10;//extracting the last digit from temp
			temp/=10; //extracting the quotient when divided by 10;
			reverse=reverse*10+r;
		}
		if(reverse==num) return true;
		return false;
	}

}
