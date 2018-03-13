# [Valid Anagram][title]

## Description

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

**Note:**
You may assume the string contains only lowercase alphabets.

**Follow up:**
What if the inputs contain unicode characters? How would you adapt your solution to such case?

## 思路一
题意是判断两个字符串是否是同字母异序词，即由相同字母变换顺序后组成的新词。
首先判断长度是否一致，如果不一致的话肯定不是。
然后将字符串转成字符数组，对字符数组进行排序，比较两个排序后的字符数组是否完全一致。

## [完整代码][src]

```java
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    char[] chs = s.toCharArray();
    char[] cht = t.toCharArray();
    Arrays.sort(chs);
    Arrays.sort(cht);
    return (new String(chs)).equals(new String(cht));
  }
}
```

## 思路二
由于题目中字符串只包含字母，因此可以使用一个数组记录26个字母出现的次数，遍历第一个字符串时次数加1，遍历第二个字符串时出现次数减1，一旦发现某个字符出现次数小于等于0时，说明该字符要么是从未出现过的字符，要么是出现次数超过第一个字符串，肯定不是同字母异序词。

## [完整代码][src]

```java
class Solution {
  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];

    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }

    for (char ch : t.toCharArray()) {
      if (count[ch - 'a'] <= 0) {
        return false;
      }
      count[ch - 'a']--;
    }

    return true;
  }
}
```

[title]: https://leetcode.com/problems/valid-anagram
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_242/Solution.java
