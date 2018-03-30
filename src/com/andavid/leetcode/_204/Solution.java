import java.util.*;

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

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countPrimes(5));
  }
}
