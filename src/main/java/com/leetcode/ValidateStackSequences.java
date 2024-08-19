package com.leetcode;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        for (int n : pushed) {
            pushed[i++] = n;
            while (i > 0 && popped[j] == pushed[i-1]) {
                i--;
                j++;
            }
        }
        return i == 0;
    }

    public static void main(String[] args) {
        ValidateStackSequences vs = new ValidateStackSequences();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println(vs.validateStackSequences(pushed, popped));
        System.out.println(vs.validateStackSequences(pushed, popped2));
    }
}
