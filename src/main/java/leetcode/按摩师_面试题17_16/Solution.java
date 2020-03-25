package leetcode.按摩师_面试题17_16;

/**
 * @author dadongge
 * @date 2020/3/24
 */
public class Solution {
    public int massage(int[] nums) {
        int len = (int)(Math.sqrt(8 * nums.length + 9) - 1) / 2;
        System.out.println(len);
        int[][] memos = new int[len][len];
        int count = 0;
        for(int i = 0; i< nums.length ; i++){
            for(int j= 0 ; j <= i + 1 ;j++){
                memos[i][j] = nums[count];
                count++;
            }
        }
        int max1 = max(0, 1, len, memos);


    }

}
