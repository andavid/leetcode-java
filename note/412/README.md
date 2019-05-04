# [Fizz Buzz][title]

## Description

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

**Example:**

```
n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```

## 思路

这个题目也太简单了吧。使用取模运算符判断一下是否是3，5，15的倍数即可。

## 实现代码

```java
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
}
```

[title]: https://leetcode.com/problems/fizz-buzz

