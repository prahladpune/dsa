package com.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Sixlets {
    List<List<Integer>> sebSeqSet = new ArrayList<>();

    public static void main(String[] argc) {
        Sixlets sixlets = new Sixlets();

        System.out.println(sixlets.solve(new int[]{123, 123, 123, 123, 123, 123, 123, 123, 123, 123}, 4));

        System.out.println(sixlets.sebSeqSet);
    }


    public int solve(int[] A, int B) {

        subsequence(A, 0, new ArrayList<>(), B);

        int count = 0;

        for (List<Integer> l : sebSeqSet) {

            int sum = 0;
            for (Integer i : l) {
                sum = sum + i;
            }
            if (sum <= 1000) {
                count++;
            }
        }

        return count;

    }

    void subsequence(int[] A, int currIndex, List<Integer> currList, int B) {
        if (currIndex == A.length) {
            if (currList.size() == B) {
                sebSeqSet.add(new ArrayList<>(currList));
            }
            return;
        }
        currList.add(A[currIndex]);
        subsequence(A, currIndex + 1, currList, B);
        currList.remove(currList.size() - 1);
        subsequence(A, currIndex + 1, currList, B);
    }
}


