package leetcode.机器人的运动范围_面试题13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/4/8
 */
public class Solution {
//    public int movingCount(int m, int n, int k){
//        return getCount(0,0,m - 1,n - 1,k,0);
//    }
//
//    private int getCount(int m, int n,int p, int q, int k,int count){
//        if(k == 0){
//            return 1;
//        }
//        if(m <= p && n <= q){
//            if(getEverNumSum(m, n) <= k){
//                return getCount(m +1,n,p,q,k,count) + getCount(m,n + 1,p,q,k,count) + 1;
//            }else{
//                return 0;
//            }
//        }else{
//            return 0;
//        }
//    }
//
//    private int getEverNumSum(int m ,int n){
//        if(m < 100 && n < 100){
//            return m / 10 + m % 10  + n / 10  + n % 10;
//        }
//        return 0;
//    }
    int get(int x) {
        int res=0;
        for (; x>0; x /= 10){
            res += x % 10;
        }
        return res;
    }

    public int movingCount(int m,int n,int k) {
        if(k == 0){
            return 1;
        }
        int[][] memos = new int[m][n];
        int ans = 1;
        memos[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || (get(i) + get(j) > k)) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    memos[i][j] |= memos[i - 1][j];
                }
                if (j - 1 >= 0) {
                    memos[i][j] |= memos[i][j - 1];
                }
                ans += memos[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int i = solution.movingCount(3, 2, 17);
        System.out.println(i);
    }
}
