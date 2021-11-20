package com.ds.backtracking;

/*
Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square,
that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output
Output 1:

2
Output 2:

0
 */
public class UniquePathIII {

    int result =0;
    int[]idxX = {-1,0,0,1};
    int[]idxY = {0,-1,1,0};
    public int solve(int[][] A) {
        int totalZeros = 0;
        int startingX =-1;
        int startingY =-1;

        for(int i=0;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                if(A[i][j]==1){
                    startingX = i;
                    startingY = j;
                }else if(A[i][j]==0){
                    totalZeros++;
                }
            }
        }

        int count =0;
        findFourDirectionalPath(A, startingX, startingY, count,totalZeros);
        return result;

    }

    void findFourDirectionalPath(int[][] A, int i, int j, int count, int totalZeros){

        if(A[i][j]==2){
            if(count == totalZeros){
                result++;
            }

            return;
        }

        for(int k=0;k<4;k++){

            int nextI = i + idxX[k];
            int nextJ = j + idxY[k];
            if(inValidMatrix(A,nextI, nextJ)){
                A[i][j] = -1;
                int incC = A[nextI][nextJ]==0?1:0;

                findFourDirectionalPath(A, nextI, nextJ, count+incC,totalZeros);
                A[i][j] = 0;
            }
        }
    }

    boolean inValidMatrix(int[][] A, int rowIndex, int columnIndex){

        int n = A.length; int m = A[0].length;
        return rowIndex >= 0 && rowIndex < n && columnIndex >= 0 && columnIndex < m && A[rowIndex][columnIndex] != -1;
    }

}
