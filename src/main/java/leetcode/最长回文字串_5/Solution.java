package leetcode.最长回文字串_5;

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
