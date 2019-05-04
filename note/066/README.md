# [Plus One][title]

## Description

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

## 思路
一个整数按位从高到低依次存储到一个 int 数组中，从数组最后一位开始加 1，如果没有进位，只需修改最后一位即可，否则继续向前进位，如果一直到第一位都有进位，说明全部都是 9，新的数组长度需要加 1，首位是 1，其余位都是 0。
时间复杂度 O(n)。

## 实现代码

```java
class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int len = digits.length;

    for (int i = len - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
      if (carry == 0) {
        break;
      }
    }

    if (carry > 0) {
      int[] result = new int[len + 1];
      result[0] = carry;
      return result;
    } else {
      return digits;
    }
  }
}
```

[title]: https://leetcode.com/problems/plus-one

