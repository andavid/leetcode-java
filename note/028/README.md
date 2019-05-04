# [Implement strStr()][title]

## Description

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

## 思路

太简单了吧，indexOf 搞定。

## 实现代码

```java
class Solution {
  public int strStr(String haystack, String needle) {
    if (null == haystack || null == needle) {
      return -1;
    }
    return haystack.indexOf(needle);
  }
}
```

[title]: https://leetcode.com/problems/implement-strstr

