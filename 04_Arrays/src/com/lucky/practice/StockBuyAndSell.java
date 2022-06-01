package com.lucky.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,2,1,1,10,2,5,2));//9+3=12
		System.out.println(maxProfit(arr));
	}

	public static int maxProfit(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int profit = 0;
		for(int i=1;i<arr.size();i++) {
			if(arr.get(i)>arr.get(i-1)) profit+=(arr.get(i)-arr.get(i-1));
		}
		return profit;
	}

}
