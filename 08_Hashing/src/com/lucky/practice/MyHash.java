package com.lucky.practice;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
	
	int BUCKET;
	ArrayList<LinkedList<Integer>> table;
	
	public MyHash(int b) {
		BUCKET=b;
		table=new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<b;i++) {
			table.add(new LinkedList<Integer>());
		}
	}	

	public void insert(int key) {
		int i = key%BUCKET;
		table.get(i).add(key);
	}
	public void delete(int key) {
		int i = key%BUCKET;
		table.get(i).remove(key);
	}
	public boolean search(int key) {
		int i = key % BUCKET ;
		return table.get(i).contains(key);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHash myHash = new MyHash(7);
		myHash.insert(49);
		myHash.insert(56);
		myHash.insert(72);
		if(myHash.search(56)) System.out.println(56+":Yes");
		else System.out.println(56+":No");
		myHash.delete(56);
		if(myHash.search(56)) System.out.println(56+":Yes");
		else System.out.println(56+":No");
	}

}
