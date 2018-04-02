# [Reverse Bits][title]

## Description

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

**Follow up:**

If this function is called many times, how would you optimize it?

## 思路

通过和 1 进行位与运算，可以得到最右边一位，由于是无符号整数，进行无符号右移操作。

将结果不断左移一位，然后加上最右边一位。

## [完整代码][src]

```java
public class Solution {
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = (result << 1) + (n & 1);
      n = n >>> 1;
    }
    return result;
  }
}
```

[title]: https://leetcode.com/problems/reverse-bits
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_190/Solution.java
