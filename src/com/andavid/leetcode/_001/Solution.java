import java.util.*;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        int[] result = new int[2];
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        return result;
      }
      map.put(nums[i], i);
    }

    return null;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i == 0 ? nums[i] : "," + nums[i]);
    }
  }
}
