# [Longest Common Prefix][title]

## Description

Write a function to find the longest common prefix string amongst an array of strings.

## 思路

求最长公共前缀。

采用分治算法。

将 LCP(S<sub>i</sub>...S<sub>j</sub>) 分解为两个子问题：
LCP(S<sub>i</sub>...S<sub>mid</sub>) 和 
LCP(S<sub>mid+1</sub>...S<sub>j</sub>)，其中 mid = (i+j) / 2.

根据这两个子问题的解，即可求出最长公共前缀。

## [完整代码][src]

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

[title]: https://leetcode.com/problems/longest-common-prefix
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_014/Solution.java
