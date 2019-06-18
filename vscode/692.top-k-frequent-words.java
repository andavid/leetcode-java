/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */
class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (map.get(o1) == map.get(o2)) {
          return o2.compareTo(o1); // 如果出现次数一样，按单词字母顺序排序
        }
        return map.get(o1) - map.get(o2);
      }
    };

    // 小顶堆 topk frequent elements
    Queue<String> queue = new PriorityQueue<>(comparator);
    for (String key : map.keySet()) {
      queue.offer(key);
      if (queue.size() > k) {
        queue.poll();
      }
    }

    // 输出频率从高到低，每次从小顶堆弹出堆顶元素，插入列表最前面
    List<String> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      result.add(0, queue.poll());
    }

    return result;
  }
}

