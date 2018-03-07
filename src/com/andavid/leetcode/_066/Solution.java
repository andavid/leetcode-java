class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int len = digits.length;

    for (int i = len - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
      if (carry == 0) {
        break;
      }
    }

    if (carry > 0) {
      int[] result = new int[len + 1];
      result[0] = carry;
      return result;
    } else {
      return digits;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] result = solution.plusOne(new int[]{1, 9, 9, 0, 9});
    for (int i = 0; i < result.length; i++) {
      System.out.print(i == 0 ? result[i] : "," + result[i]);
    }
  }
}
