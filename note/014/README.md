# [Longest Common Prefix][title]

## Description

Write a function to find the longest common prefix string amongst an array of strings.

## 思路一

求最长公共前缀。

采用分治算法。

将 LCP(S<sub>i</sub>...S<sub>j</sub>) 分解为两个子问题：
LCP(S<sub>i</sub>...S<sub>mid</sub>) 和 
LCP(S<sub>mid+1</sub>...S<sub>j</sub>)，其中 mid = (i+j) / 2.

根据这两个子问题的解，即可求出最长公共前缀。

## 实现代码

```java
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    return longestCommonPrefix(strs, 0, strs.length - 1);
  }

  public String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
      return strs[l];
    }
    int mid = (l + r) / 2;
    String left = longestCommonPrefix(strs, l, mid);
    String right = longestCommonPrefix(strs, mid + 1, r);
    return commonPrefix(left, right);
  }

  public String commonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, min);
  }
}
```

## 思路二

先找出最短字符串的长度，最长公共前缀的长度不会超过最短字符串的长度。
采用二分查找的思路逐步确定最长公共前缀。

## [完整代码][src2]

```java
class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    int minLen = Integer.MAX_VALUE;
    for(String str : strs) {
      if (str.length() < minLen) {
        minLen = str.length();
      }
    }

    int low = 1;
    int high = minLen;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isCommonPrefix(strs, mid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return strs[0].substring(0, (low + high) / 2);
  }

  public boolean isCommonPrefix(String[] strs, int mid) {
    String prefix = strs[0].substring(0, mid);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(prefix)) {
        return false;
      }
    }
    return true;
  }
}
```

[title]: https://leetcode.com/problems/longest-common-prefix

[src2]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_014/Solution2.java
