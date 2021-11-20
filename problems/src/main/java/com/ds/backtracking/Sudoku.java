package com.ds.backtracking;

/*
Problem Description

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.



A sudoku puzzle,



and its solution numbers marked in red.



Problem Constraints

N = 9


Input Format

First argument is an array of array of characters representing the Sudoku puzzle.


Output Format

Modify the given input to the required answer.


Example Input

Input 1:

A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]


Example Output

Output 1:

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

 */

public class Sudoku {

    public static void main(String[] argc) {
        Sudoku sudoku = new Sudoku();

        char[][] mat = new char[][]{
                {'.', '.'}, {'.', '.'}
        };
        sudoku.solveSudoku(mat);

    }


    public void solveSudoku(char[][] A) {

        sudoku(A, 0, 0);
    }

    boolean sudoku(char[][] mat, int i, int j) {
        if (j == 9) {
            j = 0;
            i++;
        }
        if (i == 9) return true;
        if (mat[i][j] != '.') {
            return sudoku(mat, i, j + 1);
        }
        for (int v = 1; v <= 9; v++) {

            if (isValid(mat, i, j, v)) {
                mat[i][j] = (char) ('0' + v);
                if (sudoku(mat, i, j + 1)) return true;
                mat[i][j] = '.';
            }
        }

        return false;


    }


    boolean isValid(char[][] mat, int r, int c, int val) {
        //check colum
        for (int j = 0; j < 9; j++) {
            if (mat[r][j] - '0' == val) {
                return false;
            }
        }

        //check row
        for (int i = 0; i < 9; i++) {
            if (mat[i][c] - '0' == val) {
                return false;
            }
        }

        //block

        int blockStartI = (r / 3) * 3;
        int blockStartJ = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[blockStartI + i][blockStartJ + j] - '0' == val) {
                    return false;
                }
            }
        }

        return true;
    }


}


