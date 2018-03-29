import java.util.*;

class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<String>();
    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        list.add("FizzBuzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else {
        list.add("" + i);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<String> list = solution.fizzBuzz(15);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
