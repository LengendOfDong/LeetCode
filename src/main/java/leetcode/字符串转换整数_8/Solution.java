package leetcode.字符串转换整数_8;

/**
 * @author dadongge
 * @date 2020/4/3
 */
public class Solution {
    public int myAtoi(String str) {
        //判断是否为空串，是空串直接返回0
        if("".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        String atoi = "";
        //判断第一个字符是否是- 或者 + ，数字，空格，不是则直接返回0
        if (chars[0] != '-' && chars[0] != '+' && (chars[0] > 57 || chars[0] < 48) && chars[0] != 32) {
            return 0;
        }
        //初始化当前字符
        char current = chars[0];
        //初始化上一个字符
        char last = chars[0];
        for (int i = 1; i < chars.length; i++) {
            current = chars[i];
            //上一个字符是空串
            if (last == ' ') {
                //当前字符不是 - ，+，数字以及空格的话，直接返回0 ，是其中之一则继续
                if (current != '-' && current != '+' && (current > 57 || current < 48) && current != 32) {
                    return 0;
                } else {
                    last = current;
                    continue;
                }
            }
            //上一个字符为 - 或者 +，并且当前字符为数字
            if ((last == '-' || last == '+') && (current <= 57 && current >= 48)) {
                atoi += last;
                last = current;
                continue;
            }
            //上一个字符为 - 或者 + ，并且当前字符不为数字
            if ((last == '-'|| last == '+') && (current > 57 || current < 48)) {
                return 0;
            }
            //上一个字符为数字，并且当前字符为数字
            if ((last <= 57 && last >= 48) && (current <= 57 && current >= 48)) {
                atoi += last;
                last = current;
                continue;
            }
            //上一个字符为数字，并且当前字符不为数字
            if ((last <= 57 && last >= 48) && (current > 57 || current < 48)) {
                atoi += last;
                break;
            }
        }
        //若最后一个字符为数字，则加入到返回结果中
        if(current <= 57 && current >= 48){
            atoi += current;
        }
        //用于处理全部为空格的情况
        if("".equals(atoi)){
            return 0;
        }
        //转换字符串为数字，异常中处理小于MIN_VALUE以及大于MAX_VALUE的情况
        try{
            return Integer.valueOf(atoi);
        }catch (Exception e){
            if(atoi.indexOf('-') != -1){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int i = solution.myAtoi("+1");
        System.out.println(i);
    }
}
