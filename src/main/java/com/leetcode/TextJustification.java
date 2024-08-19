package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        int i = 0;

        while(i < words.length) {
            if (length + line.size() + words[i].length() > maxWidth){
                // complete line
                int extraSpace = maxWidth - length;
                int lineSize = Math.max(1, line.size() - 1);
                int spaces = extraSpace / lineSize;
                int reminder = extraSpace % lineSize;
                for (int j = 0; j < lineSize; j++) {
                    if (reminder > 0) {
                        line.set(j, line.get(j) + IntStream.range(0, spaces+1).mapToObj(v -> " ").collect(Collectors.joining()));
                        reminder--;
                    } else{
                        line.set(j, line.get(j) + IntStream.range(0, spaces).mapToObj(v -> " ").collect(Collectors.joining()));
                    }
                }
                res.add(String.join("", line));
                line.clear();
                length = 0;
            }
            line.add(words[i]);
            length += words[i].length();
            i++;
        }
        String lastLine = String.join(" ", line);
        int trailSpace = maxWidth - lastLine.length();
        res.add(lastLine+IntStream.range(0, trailSpace).mapToObj(v -> " ").collect(Collectors.joining()));
        return res;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] lines = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = tj.fullJustify(lines, 16);
        System.out.println(res);
    }
}
