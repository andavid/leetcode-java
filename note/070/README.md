# [Climbing Stairs][title]

## Description

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Note:** Given n will be a positive integer.


**Example 1:**

```
Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
```

**Example 2:**

```
Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## 思路

爬到第 N 步有两种方法，从 第 N-1 步爬一步，或者从第 N-2 步爬两步。
题目其实就是求斐波那契数列的第 N 个数。

## [完整代码][src]

```java
class Solution {
  public int climbStairs(int n) {
    if (n == 1) return 1;

    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }
}
```

[title]: https://leetcode.com/problems/climbing-stairs
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_070/Solution.java
