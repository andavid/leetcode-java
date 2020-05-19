/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (46.16%)
 * Likes:    1885
 * Dislikes: 332
 * Total Accepted:    100.8K
 * Total Submissions: 218K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 *
 *
 *
 * Example:
 *
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 *
 *
 * Note:
 *
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 *
 *
 */
class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] map = new int[26];
    for (char task : tasks) {
      map[task - 'A']++;
    }

    Arrays.sort(map);

    int max = map[25] - 1;
    int idle = max * n;

    for (int i = 24; i >= 0 && map[i] > 0; i--) {
      idle -= (map[i] > max) ? max : map[i];
    }

    return (idle > 0) ? (tasks.length + idle) : tasks.length;
  }
}

