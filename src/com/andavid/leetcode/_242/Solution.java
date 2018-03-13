import java.util.*;

class Solution {
  public boolean isAnagram1(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    char[] chs = s.toCharArray();
    char[] cht = t.toCharArray();
    Arrays.sort(chs);
    Arrays.sort(cht);
    return (new String(chs)).equals(new String(cht));
  }

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];
    for (char ch : s.toCharArray()) {
      count[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
      if (count[ch - 'a'] <= 0) {
        return false;
      }
      count[ch - 'a']--;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isAnagram("anagram", "nagaram"));
    System.out.println(solution.isAnagram("rat", "cat"));
  }
}
