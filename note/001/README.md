# [Two Sum][title]

## Description

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## 思路

给定一个数组和一个总数，返回数组中两个数的索引，这两个数的和等于给定的总数。

遍历数组，使用一个 HashMap 记录数组里的数及其索引，如果总数与当前数的差值在 HashMap 里存在相应的记录，就找到了。

## 实现代码

```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        int[] result = new int[2];
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        return result;
      }
      map.put(nums[i], i);
    }

    return null;
  }
}
```

[title]: https://leetcode.com/problems/two-sum

