package leetcode.最长上升子序列_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dadongge
 * @date 2020/3/15
 */
public class Solution1 {
    public int lengthOfLIS(int[] nums){
        int maxLength = 0;
        for(int i = 1; i< nums.length; i++){
            int max = nums[i];
            int maxNum = 0;
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(nums[j] <= max){
                    maxNum = Math.max(maxNum,nums[j]);
                    if(list.size() == 0 ||maxNum != list.get(list.size() -1)){
                        list.add(maxNum);
                    }
                }
            }
            if(maxLength <= list.size()){
                maxLength = list.size();
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] array = new int[]{10,9,2,5,3,7,101,18};
        Solution1 solution = new Solution1();
        int i = solution.lengthOfLIS(array);
        System.out.println(i);
    }
}
