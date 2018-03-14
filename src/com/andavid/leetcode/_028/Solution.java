class Solution {
  public int strStr(String haystack, String needle) {
    if (null == haystack || null == needle) {
      return -1;
    }
    return haystack.indexOf(needle);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.strStr("hello", "ll"));
  }
}
