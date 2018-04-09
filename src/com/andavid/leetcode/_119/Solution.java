import java.util.*;

class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) return result;

    result.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = result.size() - 2; j >= 0; j--) {
        result.set(j + 1, result.get(j) + result.get(j + 1));
      }
      result.add(1);
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<Integer> result = solution.getRow(3);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
    System.out.println("");
  }
}
