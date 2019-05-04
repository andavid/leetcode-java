# [String to Integer (atoi)][title]

## Description

Implement `atoi` to convert a string to an integer.

**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 

**Requirements for atoi:**

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.



## 思路

1. 忽略前面的连续空格
2. 处理第一个非空字符，如果是 + 或者 -，记录一个标志位
3. 然后依次读取字符，如果是非数字字符或者数值超过 INT 最大值退出
4. 结果乘以标志位，和 INT 最大值、INT 最小值进行比较

## 实现代码

```java
class Solution {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    int len = str.length();
    int i = 0;

    while (i < len && str.charAt(i) == ' ') {
      i++;
    }

    if (i >= len) {
      return 0;
    }

    char sign = str.charAt(i);
    int flag = 1;
    if (sign == '-' || sign == '+') {
      flag = (sign == '-') ? -1 : 1;
      i++;
    }

    long result = 0;
    while (i < len) {
      char c = str.charAt(i++);
      if (c < '0' || c > '9' || result > Integer.MAX_VALUE) {
        break;
      }
      result = result * 10 + c - '0';s
    }

    result *= flag;
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int)result;
  }
}
```

[title]: https://leetcode.com/problems/string-to-integer-atoi

