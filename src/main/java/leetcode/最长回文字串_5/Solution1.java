package leetcode.最长回文字串_5;

/**
 * @author dadongge
 * @date 2020/3/7
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        //如果s不合法就直接返回空串
        if(s == null || s.length() < 1){
            return "";
        }
        //设置起始和结束位置
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            //单个字符作为中心点扩展
            int len1 = expandAroundCenter(s, i, i);
            //双字符作为中心点扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            //取出两个中心点返回长度的最大值
            int len = Math.max(len1, len2);
            if(len > end - start){
                //对于单字符中心点来说，回文字符串一定是奇数的，所以(len - 1)/2可以获取到与起始下标的距离
                //对于双字符中心点来说，回文字符串一定是偶数的，由于是当前字符和后一个字符组成的中心，所以去掉一个字符才合理，所以(len - 1)/2也能获取到与起始下标的距离
                start = i - (len - 1) / 2;
                //对于单字符中心点来说，例如 "abcba",从中心劈开并取整，则 当前位置 加上 len/2 才是结束下标位置
                //对于双字符中心点来说，例如 "abccba",从中心劈开并取整，则 当前位置 同样加上 len/2 才是结束下标位置
                end = i + len / 2;
            }
        }
        //获取到起始和技术位置，进行截取就获取到最长回文字符串
        return s.substring(start,end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        //第一，左右没有超出范围；第二，扩展的左右两侧相同，满足记录条件
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        //实验证明，当单字符中心和双字符中心时R - L - 1都可以表示长度
        return R - L - 1;
    }

}
