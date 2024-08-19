package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, n, n, "");
        return res;
    }
    public void generate(List<String> res, int open, int close, String op){
        if (open == 0 && close == 0) res.add(op);
        if(open > 0)
            generate(res, open-1, close, op+"(");
        if (open < close)
            generate(res, open, close-1, op+")");
    }


    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> strings = gp.generateParenthesis(3);

        System.out.println(strings);
    }
}
