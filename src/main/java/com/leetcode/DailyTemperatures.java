package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] v = stack.pop();
                res[v[1]] = i - v[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] tem = {73,74,75,71,69,72,76,73};
        int[] res = dt.dailyTemperatures(tem);
        System.out.println(Arrays.toString(res)); //[1,1,4,2,1,1,0,0]
    }
}
