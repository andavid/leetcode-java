# [Reverse String][title]

## Description

Write a function that takes a string as input and returns the string reversed.

**Example:**
Given s = "hello", return "olleh".

## 思路
使用 StringBuilder 的 reverse 方法。

## 实现代码

```java
class Solution {
  public String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}
```

[title]: https://leetcode.com/problems/reverse-string

