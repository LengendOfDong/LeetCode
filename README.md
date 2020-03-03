# LeetCode

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/

## 题目1：两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例：
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

```


## 题目2：两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

```

## 题目3：无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
示例 2:
```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```
示例 3:
```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```
## 题目4：寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:
```
nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
```

示例 2:
```
nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
```

## 题目7：整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
```
输入: 123
输出: 321
```
示例 2:
```
输入: -123
输出: -321
```
示例 3:
```
输入: 120
输出: 21
```
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

package leetcode.problem5;

import sun.rmi.runtime.Log;

import java.util.Stack;

/**
 * @author dadongge
 * @date 2020/3/3
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longestReverseStr = "";
        String middle;
        if(s.length() == 1){
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(s.length()-1)){
                return s;
            }else {
                return String.valueOf(s.charAt(0));
            }
        }
        for(int i= 1;i < s.length()-1 ; i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i + 1);
            if(s1.charAt(s1.length() - 1) == s2.charAt(0)){
                if(s2.charAt(0) == s.charAt(i)){
                    middle = s1.charAt(s1.length() - 1) + String.valueOf(s.charAt(i)) + s2.charAt(0);
                    if(s1.length() > 1 && s2.length() > 1) {
                        s1 = s1.substring(0, s1.length() - 1);
                        s2 = s2.substring(1);
                    }else{
                        longestReverseStr = middle;
                    }
                }else{
                    middle = String.valueOf(s.charAt(i));
                }
            }else {
                if(s2.charAt(0) == s.charAt(i)){
                    middle = String.valueOf(s.charAt(i)) + s2.charAt(0);
                }else if(s1.charAt(s1.length() - 1) == s.charAt(i)){
                    middle = s1.charAt(s1.length() - 1) + String.valueOf(s.charAt(i));
                }else {
                    continue;
                }
            }
            String str = getStr(middle, s1, s2);
            if(longestReverseStr.length() <= str.length()){
                longestReverseStr = str;
            }
        }
        return longestReverseStr;
    }

    public String getStr(String s,String s1,String s2){
        if(s1.charAt(s1.length() - 1) == s2.charAt(0)){
            s = s1.charAt(s1.length() - 1) + s + s2.charAt(0);
            if(s1.length() > 1 && s2.length() > 1) {
                s1 = s1.substring(0, s1.length() - 1);
                s2 = s2.substring(1);
            }else{
                return s;
            }
            return getStr(s,s1,s2);
        }else{
            return s;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = solution.longestPalindrome("aaa");
        System.out.println(s);
    }
}

