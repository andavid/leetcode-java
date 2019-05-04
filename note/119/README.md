# [Pascal's Triangle II][title]

## Description

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

**Note:**

Could you optimize your algorithm to use only O(k) extra space?

## 思路

如何从第 n-1 行的列表变化到第 n 行的列表？可以从后往前覆盖列表，将列表第 i 个元素的值与第 i-1 个元素的和覆盖到第 i 个元素，最后再添加末尾元素 1 即可。

## 实现代码

```java
class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) return result;

    result.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = result.size() - 2; j >= 0; j--) {
        result.set(j + 1, result.get(j) + result.get(j + 1));
      }
      result.add(1);
    }

    return result;
  }
}
```

[title]: https://leetcode.com/problems/pascals-triangle-ii

