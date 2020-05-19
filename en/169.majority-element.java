/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (51.54%)
 * Likes:    1721
 * Dislikes: 152
 * Total Accepted:    395.7K
 * Total Submissions: 746.3K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Example 1:
 *
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 */
class Solution {
  public int majorityElement(int[] nums) {
    return partition(nums, 0, nums.length - 1);
  }

  public int partition(int[] data, int low, int high) {
    int pivot = data[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (data[j] < pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, high);

    if (i == (data.length - 1)/2) {
      return data[i];
    } else if (i > (data.length - 1)/2) {
      return partition(data, low, i - 1);
    } else {
      return partition(data, i + 1, high);
    }
  }

  public void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}

