import java.util.*;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows <= 0) return result;

    List<Integer> pre = new ArrayList<>();
    pre.add(1);
    result.add(pre);

    for (int i = 2; i <= numRows; i++) {
      List<Integer> cur = new ArrayList<>();
      cur.add(1);
      for (int j = 1; j < i - 1; j++) {
        cur.add(pre.get(j - 1) + pre.get(j));
      }
      cur.add(1);

      result.add(cur);
      pre = cur;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> result = solution.generate(10);
    for (int i = 0; i < result.size(); i++) {
      List<Integer> list = result.get(i);
      for (int j = 0; j < list.size(); j++) {
        System.out.print(list.get(j) + " ");
      }
      System.out.println("");
    }
  }
}
