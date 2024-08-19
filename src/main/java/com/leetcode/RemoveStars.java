package com.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> ss = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '*')
                ss.pop();
            else
                ss.push(c);
        }
        return ss.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();
        System.out.println(removeStars.removeStars("leet**cod*e").equals("lecoe"));
        System.out.println(removeStars.removeStars("erase*****").equals(""));
    }
}
