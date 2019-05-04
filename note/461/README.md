# [Hamming Distance][title]

## Description

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

**Note:**
0 ≤ x, y < 2<sup>31</sup>.

**Example:**

```
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
```

## 思路一

求两个整数的二进制表示中，不同的 bit 位数量。异或操作符，相同位运算后为 0，不同位运算后为 1，因此只需要求两个整数经过异或之后，对应的二进制表示中 1 的数量。

## 实现代码

```java
class Solution {
  public int hammingDistance(int x, int y) {
    return hammingWeight(x^y);
  }

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

使用 Integer.bitCount 获取二进制数 bit 位中 1 的数量。

## [完整代码][src2]

```java
class Solution {
  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x^y);
  }
}
```

[title]: https://leetcode.com/problems/hamming-distance

[src2]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_461/Solution2.java
