package 最长回文串_409;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/3/19
 */
public class Solution {
    public int longestPalindrome(String s){
        char[] chs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:chs){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }else{
                map.put(ch,1);
            }
        }
        int count = 0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            count = count + (entry.getValue() / 2 ) * 2;
        }
        if(count < s.length()){
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int abccccdd = solution.longestPalindrome("aba");
        System.out.println(abccccdd);
    }
}
