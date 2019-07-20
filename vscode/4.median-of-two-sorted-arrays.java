/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.57%)
 * Likes:    4626
 * Dislikes: 646
 * Total Accepted:    465.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 * Example 2:
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 */
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int sum = len1 + len2;
    int i = 0, j = 0, k = 0;

    while (i < len1 && j < len2) {
      if (k >= sum / 2) {
        if (sum % 2 == 0) {
          if (i == 0) {
            return (nums2[j - 1] + Math.min(nums1[i], nums2[j])) / 2.0;
          } else if (j == 0) {
            return (nums1[i - 1] + Math.min(nums1[i], nums2[j])) / 2.0;
          } else {
            return (Math.max(nums1[i - 1], nums2[j - 1])
                  + Math.min(nums1[i], nums2[j])) / 2.0;
          }
        } else {
          return Math.min(nums1[i], nums2[j]) * 1.0;
        }
      }
      if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
      k++;
    }

    while (i < len1) {
      if (k >= sum / 2) {
        if (sum % 2 == 0) {
          if (j == 0) {
            return (nums1[i] + nums1[i - 1]) / 2.0;
          } else if (i == 0) {
            return (nums1[i] + nums2[j - 1]) / 2.0;
          } else {
            return (nums1[i] + Math.max(nums1[i - 1], nums2[j - 1])) / 2.0;
          }
        } else {
          return nums1[i] * 1.0;
        }
      }
      i++;
      k++;
    }

    while (j < len2) {
      if (k >= sum / 2) {
        if (sum % 2 == 0) {
          if (i == 0) {
            return (nums2[j] + nums2[j - 1]) / 2.0;
          } else if (j == 0) {
            return (nums1[i - 1] + nums2[j]) / 2.0;
          } else {
            return (nums2[j] + Math.max(nums1[i - 1], nums2[j - 1])) / 2.0;
          }
        } else {
          return nums2[j] * 1.0;
        }
      }
      j++;
      k++;
    }

    return 0.0;
  }
}

