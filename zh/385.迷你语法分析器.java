/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 *
 * https://leetcode-cn.com/problems/mini-parser/description/
 *
 * algorithms
 * Medium (39.30%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    3.7K
 * Total Submissions: 9.2K
 * Testcase Example:  '"324"'
 *
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 提示：你可以假定这些字符串都是格式良好的：
 *
 *
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9、[、-、,、]
 *
 *
 *
 *
 * 示例 1：
 *
 * 给定 s = "324",
 *
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 *
 *
 * 示例 2：
 *
 * 给定 s = "[123,[456,[789]]]",
 *
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 *
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * ⁠   i.  一个 integer 包含值 456
 * ⁠   ii. 一个包含一个元素的嵌套列表
 * ⁠        a. 一个 integer 包含值 789
 *
 *
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
      if (s == null) {
        return null;
      }

      if (s.charAt(0) != '[') {
        return new NestedInteger(Integer.parseInt(s));
      }

      Stack<NestedInteger> stack = new Stack<>();
      NestedInteger curr = null;

      for (int l = 0, r = 0; r < s.length(); r++) {
        char ch = s.charAt(r);
        if (ch == '[') {
          if (curr != null) {
            stack.push(curr);
          }
          curr = new NestedInteger();
          l = r + 1;
        } else if (ch == ']') {
          String num = s.substring(l, r);
          if (num.length() > 0) {
            curr.add(new NestedInteger(Integer.parseInt(num)));
          }
          if (!stack.isEmpty()) {
            NestedInteger pop = stack.pop();
            pop.add(curr);
            curr = pop;
          }
          l = r + 1;
        } else if (ch == ',') {
          if (s.charAt(r - 1) != ']') {
            curr.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
          }
          l = r + 1;
        }
      }

      return curr;
    }
}
// @lc code=end

