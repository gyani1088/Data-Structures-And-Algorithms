package com.lucky.practice;

public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] mat = {	{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};
		MatrixUtils.printMatrix(mat);
		transpose(mat);
		MatrixUtils.printMatrix(mat);
		
	}
	/**
	 * Efficient Solution: One traversal of the matrix only
	 * And only need to traverse one triangular compartment only
	 */
	public static void transpose(int[][] mat) {
		for(int i=1;i<mat.length;i++) {
			for(int j=0;j<i;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}
	
}
