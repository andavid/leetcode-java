/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (46.04%)
 * Total Accepted:    339.9K
 * Total Submissions: 730.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */
class Solution {
  public int findKthLargest(int[] data, int k) {
    return partition(data, k, 0, data.length - 1);
  }

  public int partition(int[] data, int k, int low, int high) {
    int pivot = data[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (data[j] > pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, high);

    if (i + 1 == k) {
      return data[i];
    } else if (i + 1 < k) {
      return partition(data, k, i + 1, high);
    } else {
      return partition(data, k, low, i - 1);
    }
  }

  public void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}

