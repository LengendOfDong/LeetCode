package leetcode.最长上升子序列_300;

/**
 * @author dadongge
 * @date 2020/3/15
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
             dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public static void main(String[] args){
        int[] array = new int[]{10,9,2,5,3,7,101,18};
        Solution2 solution = new Solution2();
        int i = solution.lengthOfLIS(array);
        System.out.println(i);
    }
}
