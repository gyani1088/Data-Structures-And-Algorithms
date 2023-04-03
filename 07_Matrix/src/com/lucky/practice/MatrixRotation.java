package com.lucky.practice;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] mat = {	{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}};//,
				//{13,14,15,16}};
		MatrixUtils.printMatrix(mat);
		rotateCounterClockwise(mat);
		int[][] resultant = rotateCounterClockwise(mat);
		MatrixUtils.printMatrix(resultant);
		mat = new int[][]{	{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}};
		MatrixUtils.printMatrix(mat);
		rotateCounterClockwiseInPlace(mat);
		MatrixUtils.printMatrix(mat);
		
	}
	/**
	 * Rotate counterclockwise by 90 degree
	 */
	public static int[][] rotateCounterClockwise(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] resultantMatrix = new int[cols][rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				resultantMatrix[cols-j-1][i]=mat[i][j];
			}
		}
		return resultantMatrix;
	}
	/**
	 * (In-place) This is for square matrix only
	 * Steps:
	 * 1. Find transpose
	 * 2. Reverse the individual columns.(Swap top row with bottom most row and so on)
	 */
	public static void rotateCounterClockwiseInPlace(int[][] mat) {
		//TransposeMatrix.transpose(mat);
		//Transpose
		int n = mat.length;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				int temp = mat[j][i];
				mat[j][i] = mat[i][j];
				mat[i][j] = temp;
			}
		}
		//reverse the transpose matrix (reverse individual columns)
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n-1-i][j];
				mat[n-1-i][j] = temp;
			}
		}
	}
	

}
