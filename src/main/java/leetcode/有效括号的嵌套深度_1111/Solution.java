package leetcode.有效括号的嵌套深度_1111;

import java.util.Arrays;

/**
 * 当深度一定时，A与B间隔来分是最小的。
 * @author dadongge
 * @date 2020/4/1
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] array = new int[seq.length()];
        int d = 0;
        int index = 0;
        for(char ch : seq.toCharArray()){
            if(ch == '('){
                d += 1;
                array[index] = d % 2;
                index++;
            }
            if(ch == ')'){
                array[index] = d % 2;
                d -= 1;
                index++;
            }
        }
        return array;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] ints = solution.maxDepthAfterSplit("()(())()");
        System.out.println(Arrays.toString(ints));
    }
}
