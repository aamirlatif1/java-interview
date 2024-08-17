package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TopKElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        List<Integer>[] countLists = new List[nums.length+1];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < countLists.length; i++) {
            countLists[i] = new LinkedList<>();
        }

        for (int num: nums) {
            int cc = count.getOrDefault(num, 0);
            countLists[cc].remove(Integer.valueOf(num));
            countLists[cc+1].add(num);
            count.put(num, cc+1);
        }

        System.out.println(countLists);

        int counter = 0;
        for (int i = countLists.length-1; i >0 ; i--) {
            List<Integer> values = countLists[i];
            if (!values.isEmpty()){
                while (k > 0 && !values.isEmpty()) {
                    res[counter++] = values.remove(0);
                    k--;
                }
            }
            if (k == 0) return res;
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums){
            freq.put(i, freq.getOrDefault(i, 1));
        }
        return  freq.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        TopKElements tops = new TopKElements();

        int[] nums = {7, 7};

        int[] output = tops.topKFrequent(nums, 1);
        System.out.println(Arrays.toString(output));

    }

}
