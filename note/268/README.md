# [Missing Number][title]

## Description

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

**Example 1**

```
Input: [3,0,1]
Output: 2
```

**Example 2**

```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```

**Note:**

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

## 思路一

根据高斯求和公式，1+2+3+4+……+ n = n (n+1) /2

先求出总和，再减去数组所有元素的和，就可以得到缺失的那个数了。

## 实现代码

```java
class Solution {
  public int missingNumber(int[] nums) {
    int total = nums.length * (nums.length + 1) / 2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return total - sum;
  }
}
```

## 思路二

可以使用异或运算符找出缺失的那个数。异或运算符有如下特性：

* a⊕0=a
* a⊕a=0
* a⊕b⊕a=(a⊕a)⊕b=0⊕b=b

由于数组的索引从 0 到 n-1，数组的元素从 0 到 n 各不相同且只缺失一个。
那么只需要初始化一个数 n，然后异或每一个索引和对应的元素，最后的结果就是缺失的那个数。

## [完整代码][src2]

```java
class Solution {
  public int missingNumber(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }
}
```


[title]: https://leetcode.com/problems/missing-number

[src2]: https://github.com/andavid/leetcode-java/blob/master/src/com/andavid/leetcode/_268/Solution2.java
