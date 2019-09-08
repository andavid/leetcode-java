# [Power of Three][title]

## Description

Given an integer, write a function to determine if it is a power of three.

**Follow up:**

Could you do it without using any loop / recursion?

## 思路一

判断给定整数是否是 3 的某次方。最简单的方法是迭代，反复除以 3，看最终是不是等于 1。

## 实现代码一

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

## 思路二

题目要求不用循环和递归，由于输入是一个 int，此范围内最大的 3 的次方数是 1162261467，因此只要看这个数能否被 n 整除即可。

## 实现代码二

```java
class Solution {
  public boolean isPowerOfThree(int n) {
    return (n > 0) && (1162261467 % n == 0);
  }
}
```

[title]: https://leetcode.com/problems/power-of-three
