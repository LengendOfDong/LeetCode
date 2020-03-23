package leetcode.Z字型变换_6;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/3/21
 */
public class Solution {
    public String convert(String s,int numRows){
        Map<Integer,String> map = new LinkedHashMap<>();
        int k = 1;
        boolean flag = true;
        for(char c: s.toCharArray()){
            if(map.containsKey(k)) {
                map.put(k,map.get(k) + c);
            }else{
                map.put(k,c+"");
            }
            if(!flag){
                if(k == 1){
                    k++;
                    flag=true;
                }else{
                    k--;
                }
            }else{
                if(k == numRows){
                    k--;
                    flag=false;
                }else{
                    k++;
                }
            }
        }

        String convertString = "";
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            convertString = convertString + entry.getValue();
        }
        return convertString;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String leetcodeishiring = solution.convert("LEETCODEISHIRING", 4);
        System.out.println(leetcodeishiring);
    }
}
