/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * algorithms
 * Medium (49.48%)
 * Total Accepted:    73.5K
 * Total Submissions: 147.4K
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Shuffle a set of numbers without duplicates.
 *
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of
 * [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 *
 */
class Solution {
  int[] array;
  int[] original;

  Random random = new Random();

  public Solution(int[] nums) {
    array = nums;
    original = nums.clone();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    array = original;
    original = original.clone();
    return original;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int len = array.length;
    for (int i = 0; i < len; i++) {
      swap(array, i, rand(i, len));
    }
    return array;
  }

  public int rand(int min, int max) {
    return random.nextInt(max - min) + min;
  }

  public void swap(int[] nums, int i, int j) {
    if (i == j) return;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

