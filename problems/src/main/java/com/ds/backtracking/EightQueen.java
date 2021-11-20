package com.ds.backtracking;

/*
problem statement:

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

Problem Constraints

1 <= A <= 10

Input Format

First argument is an integer n denoting the size of chessboard

Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Example Input

Input 1:

A = 4
Input 2:

A = 1


Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]
 */

import java.util.ArrayList;
import java.util.List;

public class EightQueen {

    private final List<List<String>> res = new ArrayList<>();

    public static void main(String[] argc) {
        EightQueen nQueen = new EightQueen();
        nQueen.solveNQueens(8);
    }

    public List<List<String>> solveNQueens(int A) {
        int[] column = new int[A];
        nQueen(A, column, 0);
        return res;
    }

    void nQueen(int n, int[] column, int r) {

        if (r == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int posOfQueenRow = column[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == posOfQueenRow) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                sol.add(sb.toString());
            }
            res.add(sol);
        } else {
            for (int col = 0; col < n; col++) {

                if (isValid(column, r, col)) {
                    column[r] = col;
                    nQueen(n, column, r + 1);

                }

            }
        }


    }


    boolean isValid(int[] column, int r, int c) {

        for (int i = 0; i < r; i++) {
            if (column[i] == c) {
                return false;
            }

            if ((r - c) == (i - column[i])) {
                return false;
            }

            if ((r + c) == (i + column[i])) {
                return false;
            }

        }

        return true;
    }

}


