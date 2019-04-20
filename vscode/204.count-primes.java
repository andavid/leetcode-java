/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.26%)
 * Total Accepted:    227K
 * Total Submissions: 791.5K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 *
 */
class Solution {
  public int countPrimes(int n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);

    for (int i = 2; i <= Math.sqrt(n-1); i++) {
      if (primes[i]) {
        for (int j = i*i; j < n; j += i) {
          primes[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (primes[i]) {
        count++;
      }
    }

    return count;
  }
}

