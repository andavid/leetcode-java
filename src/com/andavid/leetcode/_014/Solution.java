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

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = {"leets", "leetcode", "leet", "leeds"};
    System.out.println(solution.longestCommonPrefix(strs));
  }
}
