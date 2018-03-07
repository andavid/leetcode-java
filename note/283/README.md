# [Move Zeroes][title]

## Description

Given an array `nums`, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = `[0, 1, 0, 3, 12]`, after calling your function, nums should be `[1, 3, 12, 0, 0]`.

**Note:**

1. You must do this in-place without making a copy of the array.
1. Minimize the total number of operations.

## 思路
遍历一次数组，如果不为 0 则从前往后依次写到数组。

## [完整代码][src]

```java
class Solution {
  public void moveZeroes(int[] nums) {
    int len = nums.length;
    if (len < 2) return;

    int k = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != 0) {
        nums[k++] = nums[i];
      }
    }

    for(; k < len; k++) {
      nums[k] = 0;
    }
  }
}
```

[title]: https://leetcode.com/problems/move-zeroes
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_283/Solution.java
