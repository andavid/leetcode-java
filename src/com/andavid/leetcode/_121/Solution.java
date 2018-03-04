package com.andavid.leetcode._121;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int delta = prices[i] - min;
                if (delta > max) {
                    max = delta;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices1));
        System.out.println(solution.maxProfit(prices2));
    }
}
