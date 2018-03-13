# [Valid Palindrome][title]

## Description

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

**Note:**
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

## 思路

判断字符串是否是回文字符串，忽略除了数字和大小写字母之外的字符。
使用头和尾两个指针往中间扫描，遇到非数字和字母的字符跳过，比较两个字符是否相等（忽略大小写）。

## [完整代码][src]

```java
class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      char lc = s.charAt(i);
      char rc = s.charAt(j);

      if (!isAlphaNumeric(lc)) {
        i++;
        continue;
      }

      if (!isAlphaNumeric(rc)) {
        j--;
        continue;
      }

      if (toLowerCase(lc) != toLowerCase(rc)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

  public boolean isAlphaNumeric(char c) {
    return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
  }

  public int toLowerCase(char c) {
    return (c >= 97 && c <= 122) ? c - 32 : c;
  }
}
```

[title]: https://leetcode.com/problems/valid-palindrome
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_125/Solution.java
