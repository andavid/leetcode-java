# [Valid Parentheses][title]

## Description

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

## 思路

使用一个堆栈，遍历字符串的字符，遇到 '(' 压入 ')'，遇到 '{' 压入 '}'，遇到 '[' 压入 ']'，遇到其他字符时，判断是否与栈顶字符相同。

## 实现代码

```java
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
}
```

[title]: https://leetcode.com/problems/valid-parentheses

