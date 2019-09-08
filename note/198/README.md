# [House Robber][title]

## Description

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

## 思路一

假设 dp[i] 表示抢劫前 i 个房子的最大收益，由于不能连着抢两个房子，所以 dp[i] = Max(dp[i-2]+ nums[i], dp[i-1])

## 实现代码一

```java
class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int past = nums[0];
    int prev = Math.max(nums[0], nums[1]);
    int max = prev;

    for (int i = 2; i < nums.length; i++) {
      int sum = past + nums[i];
      if (prev > sum) sum = prev;
      past = prev;
      prev = sum;
      if (sum > max) max = sum;
    }

    return max;
  }
}
```

## 思路二

由于当前最大收益只取决于前两个的最大收益，因此代码可进行优化。

## 实现代码二

```java
class Solution {
  public int rob(int[] nums) {
    int prev = 0;
    int curr = 0;

    for (int num : nums) {
      int temp = curr;
      curr = Math.max(num + prev, curr);
      prev = temp;
    }

    return curr;
  }
}
```

[title]: https://leetcode.com/problems/house-robber
