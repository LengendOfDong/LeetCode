package leetcode.两数之和_1;

/**
 *
 * @author dadongge
 * @date 2020/2/24
 */
public class SolutionOne {
    public int[] twoSum(int[] nums, int target){
        for( int i = 0; i< nums.length ; i++){
            for (int j = i+ 1; j < nums.length ; j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i ,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
