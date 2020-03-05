package leetcode.无重复字符的最长字串_3;

/**
 * @author dadongge
 * @date 2020/2/27
 */
public class Test {
    public int lengthOfLongestSubstring(String s) {
        Integer maxLength = 0;
        for(int i = 0; i < s.length() ; i++){
            int max = getMax(s.substring(i));
            if(max > maxLength){
                maxLength = max;
            }
        }
        return maxLength;
    }

    private int getMax(String s){
        char[] chars = s.toCharArray();
        String longestStr = "";
        int max = 0;
        if(chars.length != 0){
            for(char ch : chars){
                if(longestStr.indexOf(ch) == -1){
                    longestStr = longestStr + ch;
                }else{
                    if(max <= longestStr.length()){
                        max = longestStr.length();
                    }
                    longestStr = "" + ch;
                }
            }
            if(max <= longestStr.length()){
                max = longestStr.length();
            }
        }else{
            return 0;
        }
        return max;
    }

    public static void main(String[] args){
        Test solution = new Test();
        int a = solution.lengthOfLongestSubstring("abcabcbb");
        int b = solution.lengthOfLongestSubstring("bbbbb");
        int c = solution.lengthOfLongestSubstring("pwwkew");
        int d = solution.lengthOfLongestSubstring("dvdf");
        int e = solution.lengthOfLongestSubstring(" ");
        int f = solution.lengthOfLongestSubstring("");
        int g = solution.lengthOfLongestSubstring("bbtablud");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}
