# [Number of 1 Bits][title]

## Description

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

## 思路一

给定一个无符号 32 位整数，求其对应的二进制表示中 1 的个数。

n & (n-1) 会把 n 最右边的 1 变为 0，其余位保持不变。

循环下去，直到 n 变为 0 就可以知道 1 的个数了。

## 实现代码一

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

## 思路二

n & 1 判断最后一位是否为 1，然后每次把 n 右移一位，由于是无符号整数，所以需要使用 >>>

## 完整代码二

```java
public class Solution {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count += (n & 1);
      n = n >>> 1;
    }
    return count;
  }
}
```

[title]: https://leetcode.com/problems/number-of-1-bits
