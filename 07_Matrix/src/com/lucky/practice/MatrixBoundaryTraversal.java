package com.lucky.practice;

public class MatrixBoundaryTraversal {

	public static void main(String[] args) {
		//must be a rectangular/square matrix(2D array)
		int[][] mat = {	{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}};
		printBoundaryElements(mat);
		mat = new int[][]{	{1,2,3,4},
							{5,6,7,8}};
		printBoundaryElements(mat);
		mat = new int[][]{{1},{2},{3},{4}};
		printBoundaryElements(mat);
		mat = new int[][]{{1,2,3,4}};
		printBoundaryElements(mat);

	}

	public static void printBoundaryElements(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int i=0,j=0;
		if(rows==1){
			while(j!=cols) {
				System.out.print(mat[i][j++]+" ");
			}
		}
		else if(cols==1){
			while(i!=rows) {
				System.out.print(mat[i++][j]+" ");
			}
		}
		else{	
			while(j!=cols-1) {
				System.out.print(mat[i][j++]+" ");
			}
			while(i!=rows-1) {
				System.out.print(mat[i++][j]+" ");
			}
			while(j!=0) {
				System.out.print(mat[i][j--]+" ");
			}
			while(i!=0) {
				System.out.print(mat[i--][j]+" ");
			}
		}
		System.out.println();
		
	}

}
