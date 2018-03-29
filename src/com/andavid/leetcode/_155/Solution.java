import java.util.*;

class Solution {

  public static class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
      min = Integer.MAX_VALUE;
      stack = new Stack<Integer>();
    }

    public void push(int x) {
      if (x <= min) {
        stack.push(min);
        min = x;
      }
      stack.push(x);
    }

    public void pop() {
      if (stack.pop() == min) {
        min = stack.pop();
      }
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return min;
    }
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
