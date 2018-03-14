class Solution {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    int len = str.length();
    int i = 0;

    while (i < len && str.charAt(i) == ' ') {
      i++;
    }

    if (i >= len) {
      return 0;
    }

    char sign = str.charAt(i);
    int flag = 1;
    if (sign == '-' || sign == '+') {
      flag = (sign == '-') ? -1 : 1;
      i++;
    }

    long result = 0;
    while (i < len) {
      char c = str.charAt(i++);
      if (c < '0' || c > '9' || result > Integer.MAX_VALUE) {
        break;
      }
      result = result * 10 + c - '0';
    }

    result *= flag;
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int)result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.myAtoi("     "));
    System.out.println(solution.myAtoi("-123"));
    System.out.println(solution.myAtoi("+123sd"));
    System.out.println(solution.myAtoi("  +123"));
    System.out.println(solution.myAtoi("2147483648"));
    System.out.println(solution.myAtoi("-2147483649"));
    System.out.println(solution.myAtoi("9223372036854775809"));
    System.out.println(solution.myAtoi("  A1 "));
  }
}
