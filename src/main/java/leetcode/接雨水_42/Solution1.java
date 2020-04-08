package leetcode.接雨水_42;

/**
 * @author dadongge
 * @date 2020/4/6
 */
public class Solution1 {
    public int trap(int[] height){
        int left = 0,right = height.length - 1;
        int ans = 0;
        int maxLeft = 0,maxRight = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    ans += (maxLeft - height[left]);
                }
                ++left;
            }else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    ans += (maxRight - height[right]);
                }
                --right;
            }
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
