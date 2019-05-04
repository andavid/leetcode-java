# [Roman to Integer][title]

## Description

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

## 思路

罗马数字共有7个，即Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）。
有以下几个拼写规则：

* 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
* 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
* 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
* 但是，左减时不可跨越一个位值。比如，99不可以用IC（100-1）表示，而是用XCIX（[100-10]+[10-1]）表示。（等同于阿拉伯数字每位数字分别表示。）
* 左减数字必须为一位，比如8写成VIII，而非IIX。
* 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。

根据以上几个规则，主要是右加左减，可以从右往左扫描字符串，如果遇到 I、X、C 判断是减还是加，如果遇到其他罗马数字，直接累加。

## 实现代码

```java
class Solution {
  public int romanToInt(String s) {
    int result = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      switch (ch) {
        case 'I':
          result += (result >= 5) ? -1 : 1;
          break;
        case 'V':
          result += 5;
          break;
        case 'X':
          result += (result >= 50) ? -10 : 10;
          break;
        case 'L':
          result += 50;
          break;
        case 'C':
          result += (result >= 500) ? -100 : 100;
          break;
        case 'D':
          result += 500;
          break;
        case 'M':
          result += 1000;
          break;
      }
    }
    return result;
  }
}
```

[title]: https://leetcode.com/problems/roman-to-integer

