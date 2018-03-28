# [Shuffle an Array][title]

## Description

Shuffle a set of numbers without duplicates.

**Example:**

```text
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
```

## 思路

每次随机生成一个索引，然后将该位置的元素和当前位置的元素进行交换。


## [完整代码][src]

```java
class Solution {
  int[] array;
  int[] original;

  Random rand = new Random();

  public Solution(int[] nums) {
    array = nums;
    original = nums.clone();
  }

  public int[] reset() {
    array = original;
    original = original.clone();
    return original;
  }

  public int[] shuffle() {
    int len = array.length;
    for (int i = 0; i < len; i++) {
      swap(i, rand(i, len));
    }
    return array;
  }

  /** generate a random number in the range of [min, max) */
  public int rand(int min, int max) {
    return rand.nextInt(max - min) + min;
  }

  public void swap(int i, int j) {
    if (i == j) return;
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
```

[title]: https://leetcode.com/problems/shuffle-an-array
[src]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_384/Solution.java
