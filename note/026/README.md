# [Remove Duplicates from Sorted Array][title]

## Description

Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array** in-place with O(1) extra memory.

**Example:**

```text
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
```

## 思路

题意是让你从一个有序的数组中移除重复的元素，并返回之后数组的长度。
此外，特别要注意，需要修改原数组。

判断长度小于等于 1 的话直接返回原长度即可，否则的话遍历一遍数组，用一个 tail 变量指向新的数组尾部，如果后面的元素和前面的元素不同，就让后面的元素写到 tail 所指数组元素，然后 tail 变量加一，最后返回 tail 即可。

## [完整代码][src]

```Java
class Solution {
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
}
```

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_026/Solution.java
