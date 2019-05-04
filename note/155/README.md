# [Min Stack][title]

## Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.

**Example:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

## 思路

最容易想到的思路是，使用两个 Stack，一个栈正常 push 和 pop 数据，另外一个辅助栈只压入当前栈的最小值。

也可以只使用一个栈。需要记录当前最小值，每次压入一个数时，如果它比当前最小值大，直接压入栈；如果比当前最小值还小，那么先压入当前最小值，然后更新当前最小值，最后再压入新的最小值。出栈的时候，如果值等于当前最小值，那么需要再次出栈，并更新当前最小值。

## 实现代码

```java
class MinStack {
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
```

[title]: https://leetcode.com/problems/min-stack

