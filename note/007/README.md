# [Reverse Integer][title]

## Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output:  321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

**Note:**

Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

## 思路
使用长整型保存结果。依次模 10 得到最右边一位。

## [完整代码][src]

```java
class Solution {
  public int reverse(int x) {
    long result = 0;
    for (; x != 0; x /= 10) {
      result = result * 10 + x % 10;
    }
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    }
    return (int)result;
  }
}
```

[title]: https://leetcode.com/problems/reverse-integer
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_007/Solution.java
