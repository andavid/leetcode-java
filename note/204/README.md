# [Count Primes][title]

## Description

Count the number of prime numbers less than a non-negative number, n.

## 思路

使用素数筛找出小于 n 的所有素数。找出根号 n 以内的素数，从 2 开始筛，把 2 留下，把 2 的倍数剔除掉；然后再用下一个素数，也就是 3，把 3 留下，把 3 的倍数剔除掉；不断重复下去。

```
Input: an integer n > 1
 
Let A be an array of Boolean values, indexed by integers 2 to n,
initially all set to true.
 
 for i = 2, 3, 4, ..., not exceeding √n:
  if A[i] is true:
    for j = i*i, i*i+i, i*i+2i, i*i+3i, ..., not exceeding n :
      A[j] := false
 
Output: all i such that A[i] is true.
```

## [完整代码][src]

```java
class Solution {
  public int countPrimes(int n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);

    for (int i = 2; i <= Math.sqrt(n - 1); i++) {
      if (primes[i]) {
        for (int j = i * i; j < n; j += i) {
          primes[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (primes[i]) {
        count ++;
      }
    }

    return count;
  }
}
```

[title]: https://leetcode.com/problems/count-primes
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_204/Solution.java
