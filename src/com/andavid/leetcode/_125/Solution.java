class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      char lc = s.charAt(i);
      char rc = s.charAt(j);

      if (!isAlphaNumeric(lc)) {
        i++;
        continue;
      }

      if (!isAlphaNumeric(rc)) {
        j--;
        continue;
      }

      if (toLowerCase(lc) != toLowerCase(rc)) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

  public boolean isAlphaNumeric(char c) {
    return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
  }

  public int toLowerCase(char c) {
    return (c >= 97 && c <= 122) ? c - 32 : c;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(solution.isPalindrome("0P"));
  }
}
