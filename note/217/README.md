# [Contains Duplicate][title]

## Description

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

## 思路

给定一个数组，判断数组里是否包含重复元素。

1. 使用两层 for 循环遍历数组元素是否相等，会报 `Time Limit Exceeded`，时间复杂度 O(n<sup>2</sup>)，空间复杂度 O(1)。
1. 对数组先排序，然后扫描一遍数组看相邻元素是否相等。时间复杂度取决于排序算法。
1. 使用 HashSet（集合里不允许有重复的值），把数组元素全部添加到集合里，如何集合长度和数组长度不一致，说明有重复元素。时间复杂度 O(n)，空间复杂度 O(n)。此方法相对较优。

## [完整代码][src]

```java
class Solution {
  public boolean containsDuplicate(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return false;
    }

    Set<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }

    return (set.size() != nums.length) ? true : false;
  }
}
```

[title]: https://leetcode.com/problems/contains-duplicate
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_217/Solution.java
