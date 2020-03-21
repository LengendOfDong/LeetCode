package leetcode.水壶问题;

/**
 * @author dadongge
 * @date 2020/3/21
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z){
        if(z > x + y){
            return false;
        }
        if(x > y){
            if(x - y > y){
                if(x % y  == 0 && (x - y) % y == 0 && z % y == 0){
                    return true;
                }
            }
            if(x - y < y){
                if(x % (x - y) == 0 && y % (x - y) == 0 && z % y == 0){
                    return true;
                }
            }
        }
    }
}
