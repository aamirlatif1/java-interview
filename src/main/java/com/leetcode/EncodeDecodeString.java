package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j < str.length()) {
            while (str.charAt(j) != '#') j++;
            int count = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j+1, j+1+count));
            j = j+1+count;
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeDecodeString eds = new EncodeDecodeString();

        List<String> strs = Arrays.asList("neet","code","love","you");
        String encodedString = eds.encode(strs);
        System.out.println(encodedString);
        System.out.println(eds.decode(encodedString));
    }
}
