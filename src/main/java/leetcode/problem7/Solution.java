package leetcode.problem7;

/**
 * 整数反转
 * @author dadongge
 * @date 2020/3/1
 */
public class Solution {

    public int reverse(int x) {
        String normalStr = String.valueOf(x);
        if(normalStr.startsWith("-")){
            normalStr = normalStr.substring(1);
        }
        StringBuffer sb = new StringBuffer(normalStr);
        String reverseStr = sb.reverse().toString();
        if(reverseStr.startsWith("0") && !"0".equals(normalStr)){
            reverseStr = reverseStr.substring(1);
        }
        if(String.valueOf(x).startsWith("-")){
            reverseStr = "-" + reverseStr;
        }
        int returnValue = 0;
        try{
            returnValue = Integer.valueOf(reverseStr);
        }catch(NumberFormatException e){
            return 0;
        }
        return returnValue;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int a = solution.reverse(123);
        int b = solution.reverse(-123);
        int c = solution.reverse(120);
        int d = solution.reverse(1534236469);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}