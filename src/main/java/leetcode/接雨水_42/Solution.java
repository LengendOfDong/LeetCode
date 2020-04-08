package leetcode.接雨水_42;

/**
 * @author dadongge
 * @date 2020/4/6
 */
public class Solution {
    public int trap(int[] height){
        int ans = 0;
        int size = height.length;
        for(int i = 1; i < size - 1; i ++ ){
            int maxLeft = 0;
            int maxRight = 0;
            for(int j = i; j >= 0; j--){
                maxLeft = Math.max(maxLeft,height[j]);
            }
            for(int j = i ; j < size ; j++){
                maxRight = Math.max(maxRight,height[j]);
            }
            ans += Math.min(maxLeft,maxRight) - height[i];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int trap = solution.trap(height);
        System.out.println(trap);
    }

}
