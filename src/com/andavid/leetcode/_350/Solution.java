import java.util.*;

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<Integer>();

    for (int num : nums1) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    for (int num : nums2) {
      if (map.containsKey(num)) {
        if (map.get(num) > 0) {
          list.add(num);
          map.put(num, map.get(num) - 1);
        }
      }
    }

    int size = list.size();
    int result[] = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = list.get(i);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    for (int i = 0; i < nums.length; i++) {
      System.out.print(i == 0 ? nums[i] : "," + nums[i]);
    }
  }
}
