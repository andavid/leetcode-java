package com.andavid.leetcode._026;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[tail++] = nums[i];
            }
        }

        return tail;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 3, 3, 3};

        int len = solution.removeDuplicates(nums);
        System.out.println("length = " + len);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + (i == len - 1 ? "" : ", "));
        }
    }
}
