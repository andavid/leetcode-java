# [First Unique Character in a String][title]

## Description

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Examples:**

```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

**Note:** You may assume the string contain only lowercase letters.

## 思路

依次检查字母 a-z，看看该字符是否只出现了一次，并记录最小下标。

## 实现代码

```java
class Solution {
  public int firstUniqChar(String s) {
    int out = s.length();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      int index = s.indexOf(ch);
      if (index == -1) continue;
      if (index == s.lastIndexOf(ch)) {
        out = Math.min(out, index);
      }
    }

    return (out == s.length()) ? -1 : out;
  }
}
```

[title]: https://leetcode.com/problems/first-unique-character-in-a-string

