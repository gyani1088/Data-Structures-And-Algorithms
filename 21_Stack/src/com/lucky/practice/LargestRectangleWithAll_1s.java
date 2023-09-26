package com.lucky.practice;

import java.util.Arrays;

public class LargestRectangleWithAll_1s {
    public static void main(String[] args) {
        int[][] mat = {{1,0,1,0},{0,1,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRectangularAreaOfAll1s(mat));
    }
    /**
     * we will consider every processed row as a part of histogram and this histogram keeps increasing after every
     * traversal of the next row, which will make it as a new histogram with the base as the current row.
     *
     * We add 1 to the element in the next row to the number we get from above, and consider every 0 value as 0 itself.
     * [[1,0,1,0],       [[1,0,1,0],
     *  [0,1,1,1],  ===>  [0,1,2,1],
     *  [1,1,1,1],        [1,2,3,2],
     *  [1,1,1,0]]        [2,3,4,0]]
     * */
    public static int maxRectangularAreaOfAll1s(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        //considering 1st row as a histogram
        System.out.println("mat[0]="+Arrays.toString(mat[0]));
        int res = LargestRectangularAreaHistogram.largestRectangularArea_Efficient(mat[0]);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]+=(mat[i][j]==1)?mat[i-1][j]:0;
            }
            System.out.println("mat["+i+"]="+Arrays.toString(mat[i]));
            res = Math.max(LargestRectangularAreaHistogram.largestRectangularArea_Efficient(mat[i]),res);
        }
        return res;
    }
}
