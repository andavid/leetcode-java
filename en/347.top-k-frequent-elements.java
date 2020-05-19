/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */
class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o1) - map.get(o2);
      }
    };

    // 小顶堆 topk frequent elements
    Queue<Integer> queue = new PriorityQueue<>(comparator);
    for (int key : map.keySet()) {
      if (queue.size() < k) {
        queue.offer(key);
      } else {
        int value = queue.peek();
        if (map.get(key) > map.get(value)) {
          queue.poll();
          queue.offer(key);
        }
      }
    }

    // 输出频率从高到低，每次从小顶堆弹出堆顶元素，插入列表最前面
    List<Integer> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      result.add(0, queue.poll());
    }

    return result;
  }
}

