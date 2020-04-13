package leetcode.翻转字符串里的单词_151;

/**
 * @author dadongge
 * @date 2020/4/10
 */
public class Solution2 {
    public String reverseWords(String s) {
        if(s.trim().length() == 0){
            return "";
        }
        String[] strings = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = strings.length - 1; i >= 0 ;i--){
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        String s = solution.reverseWords("the sky is blue");
        System.out.println(s);
        String s1 = solution.reverseWords("  hello world!  ");
        System.out.println(s1);
        String s2 = solution.reverseWords("a good   example");
        System.out.println(s2);
    }
}
