package com.lucky.practice;

public class SpiralTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {	{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20}};
		spiralTraversal(mat);
		mat = new int[][]{	{1,2,3,4},
							{5,6,7,8}};
		spiralTraversal(mat);
		mat = new int[][]{{1},{2},{3},{4}};
		spiralTraversal(mat);
		mat = new int[][]{{1,2,3,4}};
		spiralTraversal(mat);
		mat = new int[][]{	{1,2,3,4,5},
							{16,17,18,19,6},
							{15,24,25,20,7},
							{14,23,22,21,8},
							{13,12,11,10,9}};
		spiralTraversal(mat);
		mat = new int[][]{	{1,2,3},
							{4,5,6},
							{7,8,9},
							{10,11,12},
							{13,14,15}};
		spiralTraversal(mat);
	}
	/**
	 * Time Complexity : Theta(Rows*Columns)
	 */
	private static void spiralTraversal(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int top = 0, bottom = rows-1, left = 0, right = cols-1;
		int i=0,j=0;
		while(top<=bottom && left<=right) {
			while(j<=right) {
				System.out.print(mat[i][j++]+" ");
			}
			j--;
			i=++top;
			while(i<=bottom) {
				System.out.print(mat[i++][j]+" ");
			}
			i--;
			j=--right;
			if(top<=bottom) {
			while(j>=left) {
				System.out.print(mat[i][j--]+" ");
			}
			}
			j++;
			i=--bottom;
			if(left<=right) {
			while(i>=top) {
				System.out.print(mat[i--][j]+" ");
			}
			}
			i++;
			j=++left;
			System.out.print(", ");
		}
		System.out.println();
		
	}

}
