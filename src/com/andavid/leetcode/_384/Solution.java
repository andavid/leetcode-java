import java.util.*;

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

  public void print(int[] nums) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    Solution solution = new Solution(nums);
    int[] param1 = solution.shuffle();
    solution.print(param1);
    int[] param2 = solution.reset();
    solution.print(param2);
  }
}
