# [Merge Sorted Array][title]

## Description

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

**Note:**

You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

## 思路

从后往前填充即可。

当两个数组都还有元素的时候，将较大的元素填充到较长的数组 1 的末尾。

如果有一个数组的数用完了：
* 如果是第一个数组的数用完了，直接把剩下的数组 2 全部填充到数组 1
* 如果是第二个数组的数用完了，剩下的全是数组 1，不用填充了


## [完整代码][src]

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
      nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
    }

    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}
```

[title]: https://leetcode.com/problems/merge-sorted-array
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_088/Solution.java
