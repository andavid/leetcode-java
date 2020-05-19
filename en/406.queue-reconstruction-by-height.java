/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (60.69%)
 * Likes:    1775
 * Dislikes: 198
 * Total Accepted:    88.9K
 * Total Submissions: 146.1K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 *
 *
 */
class Solution {
  public int[][] reconstructQueue(int[][] people) {
    // [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    // [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
    Arrays.sort(people, new Comparator<int[]>() {
      public int compare(int[] p1, int[] p2) {
        return (p1[0] != p2[0]) ? (p2[0] - p1[0]) : (p1[1] - p2[1]);
      }
    });

    List<int[]> result = new LinkedList<>();
    for (int[] p : people) {
      result.add(p[1], p);
    }

    return result.toArray(new int[people.length][]);
  }
}

