# [Maximum Subarray][title]

## Description

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

**More practice:**

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## 思路

为了求整个字符串最大的子序列和，可以先求子问题，得到局部最大值，然后更新全局最大值。

可以从前往后扫描，假设 dp[i] 表示前 i 个元素的最大子序列和，如果 dp[i] 为负数，那么 dp[i+1] 等于第 i+1 个元素的值，否则 dp[i+1] 等于 dp[i] 加上第 i+1 个元素的值，由此得到前 i+1 个元素的局部最大子序列和。

如果局部最大值大于全局最大值，则进行更新。

## [完整代码][src]

```java
class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int sum = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum = (sum < 0) ? nums[i] : (sum + nums[i]);
      if (sum > max) max = sum;
    }

    return max;
  }
}
```

[title]: https://leetcode.com/problems/maximum-subarray
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_053/Solution.java
