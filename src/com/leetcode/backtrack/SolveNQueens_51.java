package com.leetcode.backtrack;

import java.util.*;

public class SolveNQueens_51 {

    public static void main(String[] args) {
        SolveNQueens_51 instance = new SolveNQueens_51();
        instance.solveNQueens(4).forEach( list -> {
            list.forEach(element -> System.out.println(element +","));
            System.out.println();
        });
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] queens = new char[n][n];
        //初始化空棋盘
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            queens[i] = row;
        }
        backtrack(res, queens, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] queens, int rowIndex) {
        int n = queens.length;
        if (rowIndex == n) {
            List<String> rows = new ArrayList<>();
            for( int i =0; i < queens.length; i++){
                String rowStr = String.valueOf(queens[i]);
                rows.add(rowStr);
            }
            res.add(rows);
            return ;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(queens, rowIndex,i)) {
                queens[rowIndex][i] = 'Q';
                backtrack(res, queens, rowIndex + 1);
                queens[rowIndex][i] = '.';
            }
        }

    }

    private boolean isValid(char[][] queens, int rowIndex, int col) {

        //剪枝
        //不用判断当前行

        //判断当前列的时候不用只用判断之前行
        for (int i = 0; i < rowIndex; ++i) {
            if (queens[i][col] == 'Q') return false;
        }

        //左上方
        for (int i = rowIndex - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (queens[i][j] == 'Q') return false;
        }

        //右上方
        for (int i = rowIndex - 1, j = col + 1; i >= 0 && j < queens.length; --i, ++j) {
            if (queens[i][j] == 'Q') return false;
        }
        return true;
    }
}
