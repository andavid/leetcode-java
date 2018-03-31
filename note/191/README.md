# [Number of 1 Bits][title]

## Description

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

## 思路

给定一个无符号 32 位整数，求其对应的二进制表示中 1 的个数。

n & (n-1) 会把 n 最右边的 1 变为 0，其余位保持不变。

循环下去，直到 n 变为 0 就可以知道 1 的个数了。

## [完整代码][src]

```java
class Solution {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count ++;
      n &= (n - 1);
    }
    return count;
  }
}
```

[title]: https://leetcode.com/problems/number-of-1-bits
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_191/Solution.java
