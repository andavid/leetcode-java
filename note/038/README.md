# [count-and-say][title]

## Description

The count-and-say sequence is the sequence of integers with the first five terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

**Example 1:**

```
Input: 1
Output: "1"
```

**Example 2:**

```
Input: 4
Output: "1211"
```

## 思路
遍历字符串，如果当前字符和上一个字符不相同，则输出计数情况，否则计数器加1。

## 实现代码

```java
class Solution {
  public String countAndSay(int n) {
    String str = "1";
    for (int i = 1; i < n; i++) {
      str = say(str);
    }
    return str;
  }

  public String say(String str) {
    if (str.length() == 1) {
      return "1" + str;
    }
    StringBuilder sb = new StringBuilder();
    int count = 1;
    int i = 1;
    for (; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i - 1)) {
        sb.append(count).append(str.charAt(i - 1));
        count = 1;
      } else {
        count++;
      }
    }
    sb.append(count).append(str.charAt(i - 1));
    return sb.toString();
  }
}
```

[title]: https://leetcode.com/problems/count-and-say

