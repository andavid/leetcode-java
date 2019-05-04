# [Rotate Array][title]

## Description

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array `[1,2,3,4,5,6,7]` is rotated to `[5,6,7,1,2,3,4]`.

**Note:**  
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

## 思路
三步反转法

(X<sup>T</sup>Y<sup>T</sup>)<sup>T</sup> = YX

这里需要特别注意，向右移动的步数 k 有可能大于数组的长度，因此要做个取模处理。

## 实现代码

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from++] = nums[to];
            nums[to--] = temp;
        }
    }
}
```

[title]: https://leetcode.com/problems/rotate-array

