# [Intersection of Two Arrays II][title]

## Description

Given two arrays, write a function to compute their intersection.

**Example:**
Given nums1 = `[1, 2, 2, 1]`, nums2 = `[2, 2]`, return `[2, 2]`.

**Note:**
* Each element in the result should appear as many times as it shows in both arrays.
* The result can be in any order.

**Follow up:**
* What if the given array is already sorted? How would you optimize your algorithm?
* What if nums1's size is small compared to nums2's size? Which algorithm is better?
* What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

## 思路
使用 HashMap 遍历第一个数组，并记录数组元素出现的次数。
然后遍历第二个数组，如果数组元素在 HashMap 中，则把该元素添加到 List，同时 HashMap 该元素出现次数减一。
最后把 List 转成 int 数组即可。
时间复杂度 O(n)，空间复杂度 O(n)。

## [完整代码][src]

```java
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<Integer>();

    for (int num : nums1) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    for (int num : nums2) {
      if (map.containsKey(num)) {
        if (map.get(num) > 0) {
          list.add(num);
          map.put(num, map.get(num) - 1);
        }
      }
    }

    int size = list.size();
    int result[] = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
```

[title]: https://leetcode.com/problems/intersection-of-two-arrays-ii
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_350/Solution.java
