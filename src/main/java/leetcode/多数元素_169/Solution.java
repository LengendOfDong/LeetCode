package leetcode.多数元素_169;

import java.util.Arrays;

/**
 * 排序
 * 排序后，由于众数大于 n / 2,所以无论是奇数数组还是偶数数组，下标为 nums.length / 2 处的元素一定是众数
 * @author dadongge
 * @date 2020/3/23
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
