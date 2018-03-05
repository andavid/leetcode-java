import java.util.*;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return false;
    }

    Set<Integer> set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }

    return (set.size() != nums.length) ? true : false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.containsDuplicate(new int[]
      {1, 2, 1, 3, 4}));
    System.out.println(solution.containsDuplicate(new int[]
      {1, 2, 3, 4, 5}));
  }
}
