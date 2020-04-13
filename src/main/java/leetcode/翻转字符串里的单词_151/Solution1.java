package leetcode.翻转字符串里的单词_151;

/**
 * @author dadongge
 * @date 2020/4/10
 */
public class Solution1 {
    public String reverseWords(String s) {
        if (s.trim().length() == 0) {
            return "";
        }
        char[] chars = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        //遍历所有的字符，倒序遍历
        for(int i = chars.length - 1; i >= 0; i--){
            if(chars[i] == 32){
                continue;
            }
            //装入每个字符
            stringBuilder.append(chars[i]);
            //后一个存在且为空格，当前字符不为空格，则需要翻转
            if((i - 1) >= 0 && chars[i - 1] == 32 && chars[i] != 32){
                sb.append(stringBuilder.reverse());
                sb.append(' ');
                stringBuilder.delete(0,stringBuilder.length());
            }
        }
        sb.append(stringBuilder.reverse());
        return sb.toString();
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        String s = solution.reverseWords("the sky is blue");
        System.out.println(s);
        String s1 = solution.reverseWords("  hello world!  ");
        System.out.println(s1);
        String s2 = solution.reverseWords("a good   example");
        System.out.println(s2);
    }
}
