/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (25.10%)
 * Likes:    3182
 * Dislikes: 115
 * Total Accepted:    318.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 *
 * LRUCache cache = new LRUCache(2);
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 *
 *
 *
 */
class Node {
  public int key, val;
  public Node next, prev;

  public Node(int k, int v) {
    this.key = k;
    this.val = v;
  }
}

class DoubleList {
  private Node head, tail;
  private int size;

  public DoubleList() {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  public void addFirst(Node x) {
    x.next = head.next;
    x.prev = head;
    head.next.prev = x;
    head.next = x;
    size++;
  }

  public void remove(Node x) {
    x.prev.next = x.next;
    x.next.prev = x.prev;
    size--;
  }

  public Node removeLast() {
    if (tail.prev == head) {
      return null;
    }
    Node last = tail.prev;
    remove(last);
    return last;
  }

  public int size() {
    return size;
  }
}

class LRUCache {
  private int cap;
  private HashMap<Integer, Node> map;
  private DoubleList cache;

  public LRUCache(int capacity) {
    this.cap = capacity;
    map = new HashMap<>();
    cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    int val = map.get(key).val;
    put(key, val);
    return val;
  }

  public void put(int key, int value) {
    Node x = new Node(key, value);

    if (map.containsKey(key)) {
      cache.remove(map.get(key));
    } else {
      if (cap == cache.size()) {
        Node last = cache.removeLast();
        map.remove(last.key);
      }
    }

    cache.addFirst(x);
    map.put(key, x);
  }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

