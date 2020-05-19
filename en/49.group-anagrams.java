/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (46.25%)
 * Likes:    1856
 * Dislikes: 120
 * Total Accepted:    370.8K
 * Total Submissions: 768.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * Note:
 *
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 *
 */
class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) return new ArrayList();

    Map<String, List<String>> map = new HashMap<>();
    int[] count = new int[26];

    for (String str : strs) {
      Arrays.fill(count, 0);
      for (char ch : str.toCharArray()) {
        count[ch - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < count.length; i++) {
        sb.append("#");
        sb.append(count[i]);
      }
      String key = sb.toString();

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList());
      }
      map.get(key).add(str);
    }

    return new ArrayList(map.values());
  }
}
