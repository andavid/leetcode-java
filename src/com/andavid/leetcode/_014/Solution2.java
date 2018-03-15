class Solution2 {
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

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = {"leets", "leetcode", "leet", "leeds"};
    System.out.println(solution.longestCommonPrefix(strs));
  }
}
