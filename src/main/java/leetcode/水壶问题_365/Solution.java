package leetcode.水壶问题_365;

/**
 * @author dadongge
 * @date 2020/3/21
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z){
        if(x+y<z){
            return false;
        }
        if(x == 0 || y == 0){
            return z==0 || x+y==z;
        }
        return z % gcb(x,y) == 0;
    }

    int gcb(int m, int n) {
        return  n == 0 ? m : gcb(n,m%n);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        boolean b = solution.canMeasureWater(3, 5, 4);
        System.out.println(b);
    }
}
