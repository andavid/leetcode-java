# [Reverse String][title]

## Description

Write a function that takes a string as input and returns the string reversed.

**Example:**
Given s = "hello", return "olleh".

## 思路
使用 StringBuilder 的 reverse 方法。

## [完整代码][src]

```java
class Solution {
  public String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}
```

[title]: https://leetcode.com/problems/reverse-string
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_344/Solution.java
