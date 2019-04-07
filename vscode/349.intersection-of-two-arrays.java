import java.util.Set;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (52.99%)
 * Total Accepted:    207.2K
 * Total Submissions: 385.6K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }

    Set<Integer> resultSet = new HashSet<>();
    for (int num: nums2) {
      if (set.contains(num)) {
        resultSet.add(num);
      }
    }
    
    int[] ret = new int[resultSet.size()];
    int i = 0;
    for (int num : resultSet) {
      ret[i++] = num;
    }
    return ret;
  }
}

