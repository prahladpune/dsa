package com.ds.backtracking;

import java.util.*;

/*
Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints

1 <= length of the array <= 12

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the number of permutations of A that are squareful.



Example Input

Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output

Output 1:

 1
Output 2:

 2

 */

/*
Algo: Hamiltonian Path algo is used to solve this problem.

Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge
(in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
 */
public class SquarefulArrays {
    public int count = 0;

    public static void main(String[] argc) {
        SquarefulArrays squarefulArrays = new SquarefulArrays();
        System.out.println(squarefulArrays.solve(new int[]{36229, 1020, 69, 127, 162, 127}));
    }

    public int solve(int[] A) {

        if (A.length == 1) return 0;

        Map<Integer, List<Integer>> adjListArr = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            Integer key = A[i];
            List<Integer> adjList = adjListArr.getOrDefault(key, new ArrayList<>());
            for (int j = 0; j < A.length; j++) {

                if (i != j) {
                    int sum = A[i] + A[j];
                    int sqrt = (int) Math.sqrt(sum);
                    if (sqrt * sqrt == sum) {
                        adjList.add(A[j]);
                        adjListArr.put(A[i], adjList);
                    }
                }
            }
        }

        if (adjListArr.size() == 1) {
            return 1;
        }
        int[] curr = new int[A.length];

        for (int j : A) {
            Set<Integer> visitedSet = new HashSet<>();
            curr[0] = j;
            visitedSet.add(j);
            countSquareFullArray(curr, 0, visitedSet, adjListArr, j, A.length);

        }

        return count;

    }

    void countSquareFullArray(int[] curr, int index, Set<Integer> visitedSet, Map<Integer, List<Integer>> adjListArr, int currElement, int n) {

        if (index == n - 1) {
            if (curr.length != n) {
                return;
            }
            count = count + 1;

            return;
        }

        List<Integer> adjList = adjListArr.get(currElement);
        if (adjList != null) {
            for (Integer adj : adjList) {
                if (!visitedSet.contains(adj)) {
                    visitedSet.add(adj);
                    curr[index + 1] = adj;
                    countSquareFullArray(curr, index + 1, visitedSet, adjListArr, adj, n);
                    visitedSet.remove(adj);
                }
            }
        }


    }

}
