class Solution {
  public String countAndSay(int n) {
    String str = "1";
    for (int i = 1; i < n; i++) {
      str = say(str);
    }
    return str;
  }

  public String say(String str) {
    if (str.length() == 1) {
      return "1" + str;
    }
    StringBuilder sb = new StringBuilder();
    int count = 1;
    int i = 1;
    for (; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(i - 1)) {
        sb.append(count).append(str.charAt(i - 1));
        count = 1;
      } else {
        count++;
      }
    }
    sb.append(count).append(str.charAt(i - 1));
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countAndSay(1));
    System.out.println(solution.countAndSay(8));
  }
}
