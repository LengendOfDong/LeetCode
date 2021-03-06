package leetcode.两数之和_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/2/24
 */
public class SolutionTwo {
    public  int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException("No two sum solution");
    }
}
