# [Pascal's Triangle][title]

## Description

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,    
Return

```
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## 思路

第 n 行有 n 个数字，第一个和最后一个数字为 1，其余每个数字等于它的左上方与右上方两个数字之和。
因此，可以根据第 n - 1 行得到第 n 行。

## [完整代码][src]

```java
class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows <= 0) return result;

    List<Integer> pre = new ArrayList<>();
    pre.add(1);
    result.add(pre);

    for (int i = 2; i <= numRows; i++) {
      List<Integer> cur = new ArrayList<>();
      cur.add(1);
      for (int j = 1; j < i - 1; j++) {
        cur.add(pre.get(j - 1) + pre.get(j));
      }
      cur.add(1);

      result.add(cur);
      pre = cur;
    }

    return result;
  }
}
```

[title]: https://leetcode.com/problems/pascals-triangle
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_118/Solution.java
