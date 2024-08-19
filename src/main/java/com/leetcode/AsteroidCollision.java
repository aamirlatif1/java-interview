package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int x : asteroids) {
            if (stack.isEmpty() || x > 0 || (x < 0 && stack.peek() < 0)) {
                stack.push(x);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(x)) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(x)) {
                    stack.pop();
                } else {
                    if (stack.isEmpty() ||  stack.peek() < 0) {
                        stack.push(x);
                    }
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int x : asteroids) {
            while(!stack.isEmpty() && x < 0 && stack.peek() > 0){
                int diff = x + stack.peek();
                if(diff < 0)
                    stack.pop();
                else if(diff > 0)
                    x = 0;
                else {
                    x = 0;
                    stack.pop();
                }
            }
            if (x != 0)
                stack.push(x);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        int[] values = {10,2,-5};
        int[] res = ac.asteroidCollision2(values);
        System.out.println(Arrays.toString(res));
    }
}
