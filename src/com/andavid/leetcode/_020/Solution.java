import java.util.*;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i ++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if (c == '{') {
        stack.push('}');
      } else if (stack.empty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isValid("([])"));
  }
}
