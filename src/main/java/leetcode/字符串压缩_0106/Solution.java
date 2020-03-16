package leetcode.字符串压缩_0106;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dadongge
 * @date 2020/3/16
 */
public class Solution {
    public String compressString(String S){
        if("".equals(S)){
            return S;
        }
        char[] chars = S.toCharArray();
        char last = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < chars.length; i++){
            if(last == chars[i]){
                count++;
                last = chars[i];
            }else{
                sb.append(last).append(count);
                count =1;
                last = chars[i];
            }
        }
        sb.append(last).append(count);
        if(sb.length() < S.length()){
            return sb.toString();
        }else {
            return S;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = solution.compressString("");
        System.out.println(s);
    }
}
