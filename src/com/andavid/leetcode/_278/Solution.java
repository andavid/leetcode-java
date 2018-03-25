class Solution {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  public boolean isBadVersion(int version) {
    if (version >= 2) return true;
    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.firstBadVersion(5));
  }
}
