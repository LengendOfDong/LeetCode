package leetcode.翻转字符串里的单词_151;

import java.net.Socket;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author dadongge
 * @date 2020/4/10
 */
public class Solution {
    public String reverseWords(String s) {
        if (s.trim().length() == 0) {
            return "";
        }
        String regex = "\\s+";
        String[] split = s.trim().split(regex);
        Stack<String> stack = new Stack<>();
        for (String str : split) {
            stack.push(str);
            stack.push(" ");
        }
        String returnStr = "";
        while(!stack.isEmpty()){
            returnStr += stack.pop();
        }
        return returnStr.trim();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = solution.reverseWords("the sky is blue");
        System.out.println(s);
        String s1 = solution.reverseWords("  hello world!  ");
        System.out.println(s1);
        String s2 = solution.reverseWords("a good   example");
        System.out.println(s2);
    }
}
