# [Single Number][title]

## Description

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

## 思路

给定一个数组，数组中除了一个数只出现了一次，其他数都出现了两次，找出那个数。

把所有的数字进行异或运算即可。


## 实现代码

```java
class Solution {
  public int singleNumber(int[] nums) {
    int n = 0;
    for (int num : nums) {
      n ^= num;
    }
    return n;
  }
}
```

[title]: https://leetcode.com/problems/single-number

