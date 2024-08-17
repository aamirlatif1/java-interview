package com.leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0 && num < nums.length) {
                if (nums[num] > 0 &&  nums[num] < nums.length)
                    
                nums[num] = Integer.MAX_VALUE;
            }
        }
        System.out.println(Arrays.toString(nums));
        if (nums.length > 1 && nums[1] != Integer.MAX_VALUE) return 1;
        int index = 1;
        while (index < nums.length){
            if (nums[index] != Integer.MAX_VALUE) return index+1;
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstMissingPositive fm = new FirstMissingPositive();
        int[]nums = {3,4,-1,1};
        System.out.println(fm.firstMissingPositive(nums));
    }
}
