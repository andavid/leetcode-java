# [Best Time to Buy and Sell Stock II][title]

## Description

Say you have an array for which the *i*<sup>th</sup> element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

## 思路
题意是给出一个数组代表每天的股票金额，在每天只能买或卖的情况下求出收益最高值，可以进行多次买卖交易，但是必须先卖掉才能再买。

只需要把所有相邻递增的值都加起来即可。

## 实现代码

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
```

[title]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

