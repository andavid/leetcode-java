class Solution {
  public int firstUniqChar(String s) {
    int out = s.length();

    for (char ch = 'a'; ch <= 'z'; ch++) {
      int index = s.indexOf(ch);
      if (index == -1) continue;
      if (index == s.lastIndexOf(ch)) {
        out = Math.min(out, index);
      }
    }

    return (out == s.length()) ? -1 : out;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.firstUniqChar("leetcode"));
    System.out.println(solution.firstUniqChar("loveleetcode"));
    System.out.println(solution.firstUniqChar("llll"));
  }
}
