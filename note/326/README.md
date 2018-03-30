# [Power of Three][title]

## Description

Given an integer, write a function to determine if it is a power of three.

**Follow up:**

Could you do it without using any loop / recursion?

## 思路

判断给定整数是否是 3 的某次方。最简单的方法是迭代，反复除以 3，看最终是不是等于 1。

## [完整代码][src]

```java
class Solution {
  public boolean isPowerOfThree(int n) {
    if (n < 1) return false;
    while (n % 3 == 0) {
      n /= 3;
    }
    return n == 1;
  }
}
```

[title]: https://leetcode.com/problems/power-of-three
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_326/Solution.java
