/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (47.22%)
 * Likes:    841
 * Dislikes: 48
 * Total Accepted:    214.6K
 * Total Submissions: 440.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 *
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 *
 *
 */
class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    backtrace(answer, track, 1, n, k);
    return answer;
  }

  public void backtrace(List<List<Integer>> answer, List<Integer> track, int start, int end, int k) {
    if (track.size() == k) {
      answer.add(new ArrayList<>(track));
    } else {
      for (int i = start; i <= end - (k - track.size()) + 1; i++) {
        track.add(i);
        backtrace(answer, track, i + 1, end, k);
        track.remove(track.size() - 1);
      }
    }
  }
}

