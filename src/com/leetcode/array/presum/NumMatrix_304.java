package com.leetcode.array.presum;

public class NumMatrix_304 {

    int[][] preSum;

    /*public NumMatrix_304(int[][] matrix) {
        int row_length = matrix.length;
        int col_length = matrix[0].length;
        preSum = new int[row_length+1][col_length+1];
        for (int row = 1; row <= row_length; row++) {
            for (int col = 1; col <= col_length; col++) {
                preSum[row][col] = preSum[row-1][col] + preSum[row][col-1] + matrix[row-1][col-1] - preSum[row-1][col-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }*/
    public NumMatrix_304(int[][] matrix) {
        int row_length = matrix.length;
        int col_length = matrix[0].length;
        preSum = new int[row_length][col_length];
        for (int row = 0; row < row_length; row++) {
            for (int col = 0; col < col_length; col++) {
                if (row == 0 || col == 0 ) {
                    preSum[row][col] = matrix[row][col];
                    if (row >0) {preSum[row][col] += preSum[row-1][col];}
                    if (col >0) {preSum[row][col] += preSum[row][col-1];}
                } else {
                    preSum[row][col] = preSum[row - 1][col] + preSum[row][col - 1] + matrix[row][col] - preSum[row - 1][col - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 || col1 == 0){
            if (row1 > 0) {
                return preSum[row2][col2] - preSum[row1-1][col2];
            } else if (col1 >0) {
                return preSum[row2][col2] - preSum[row2][col1-1];
            } else {
                return preSum[row2][col2];
            }
        }
        return preSum[row2][col2] - preSum[row2][col1-1] - preSum[row1-1][col2] + preSum[row1-1][col1-1];
    }
}
