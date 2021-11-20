package com.ds.backtracking;

/*
Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.

A special operation involves multiplying any element by -1 i.e. changing its sign.

Return 1 if it is possible to achieve the answer, otherwise 0.



Problem Constraints
1 <= N, M <= 10

0 <= A <= 5

-105 <= B[i][j], C <= 105
 */

public class VerticalAndHorizontalSum {

    public static void main(String[] argc) {
        VerticalAndHorizontalSum verticalAndHorizontalSum = new VerticalAndHorizontalSum();

        int A = 2;
        int[][] B =
                {
                        {-4, 8, -3, 1},
                        {-6, -1, 9, -6},
                        {-1, -8, 7, -6}
                };
        int C = 8;

        System.out.println(verticalAndHorizontalSum.solve(A, B, C));

    }

    public int solve(int A, int[][] B, int C) {

        if (A == -1) {
            return 0;
        }

        int n = B.length;
        int m = B[0].length;
        int ret = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = j; k < m; k++) {
                    sum = sum + B[i][k];
                    if (sum > C) {
                        ret = 0;
                        for (int l = j; l <= k; l++) {
                            B[i][l] = -B[i][l];
                            ret = ret | solve(A - 1, B, C);
                            B[i][l] = -B[i][l];
                        }
                        return ret;
                    }
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int k = i; k < n; k++) {
                    sum = sum + B[i][j];
                    if (sum > C) {
                        ret = 0;
                        for (int l = i; l < k; l++) {
                            B[l][j] = -B[l][j];
                            int r = solve(A - 1, B, C);
                            ret = ret | r;
                            B[l][j] = -B[l][j];
                        }

                        return ret;
                    }
                }
            }
        }

        return ret;

    }


}


