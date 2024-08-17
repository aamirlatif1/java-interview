package com.leetcode;

import java.util.Arrays;

public class SortColors {


    public void sortColors(int[] nums) {
        for (int k = 0; k < 2; k++) {
            int i = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= k) {
                    i++;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();

        int[] nums = {1,2,2,1,0,0,2,1,1,0,0};

        sortColors.sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

}
