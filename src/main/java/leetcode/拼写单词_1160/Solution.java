package leetcode.拼写单词_1160;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/3/17
 */
public class Solution {
    public int countCharacters(String[] words,String chars){
        Map<Character, Integer> map = getCharacterIntegerMap(chars);
        System.out.println(map);
        int count = 0;
        for(String str:words){
            Map<Character, Integer> formatMap = getCharacterIntegerMap(str);
            boolean flag = true;
            for(Map.Entry<Character,Integer> entry:formatMap.entrySet()){
                if(!map.containsKey(entry.getKey()) || map.get(entry.getKey()) < entry.getValue()){
                    flag = false;
                }
            }
            if(flag){
                count  = count + str.length();
            }
        }
        return count;
    }

    private Map<Character, Integer> getCharacterIntegerMap(String chars) {
        char[] cs = chars.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:cs){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }else {
                map.put(ch,1);
            }
        }
        return map;
    }

//    private int getCount(Map<Character, Integer> map, char[] chs) {
//        int count = 0;
//        for(char c : chs){
//            if(map.containsKey(c) && map.get(c) != 0){
//                map.put(c , map.get(c) - 1);
//                count++;
//            }else{
//                return 0;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args){
        String[] words = new String[]{"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        Solution solution = new Solution();
        int i = solution.countCharacters(words, chars);
        System.out.println(i);
    }
}
