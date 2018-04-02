class Solution {
  public int hammingDistance(int x, int y) {
    return hammingWeight(x^y);
  }

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count ++;
      n &= (n - 1);
    }
    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.hammingDistance(1, 4));
  }
}
