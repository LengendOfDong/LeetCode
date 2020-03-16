package leetcode.最长上升子序列_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dadongge
 * @date 2020/3/14
 */
public class Solution {
    public int lengthOfLIS(int[] nums){
        int maxLength =0;
        for(int i=0; i<nums.length;i++){
            int m = 1;
            while(i + m < nums.length) {
                List<Integer> arrlist = new ArrayList<>();
                int max = nums[i];
                arrlist.add(max);
                int count = 1;
                for (int j = i + m; j < nums.length; j++) {
                    max = Math.max(max, nums[j]);
                    if (max != arrlist.get(arrlist.size() - 1)) {
                        count++;
                        arrlist.add(max);
                    }
                }
                if(maxLength <= count){
                    maxLength = count;
                }
                m++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] array = new int[]{10,9,2,10,3,9,4,8};
        Solution solution = new Solution();
        int i = solution.lengthOfLIS(array);
        System.out.println(i);
    }
}
