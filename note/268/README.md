# [Missing Number][title]

## Description

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

**Example 1**

```
Input: [3,0,1]
Output: 2
```

**Example 2**

```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```

**Note:**

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

## 思路

根据高斯求和公式，1+2+3+4+……+ n = n (n+1) /2

先求出总和，再减去数组所有元素的和，就可以得到缺失的那个数了。

## [完整代码][src]

```java
class Solution {
  public int missingNumber(int[] nums) {
    int total = nums.length * (nums.length + 1) / 2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return total - sum;
  }
}
```

[title]: https://leetcode.com/problems/missing-number
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_268/Solution.java
