package leetcode.机器人的运动范围_面试题13;

/**
 * 每一个节点都可以分解成横向的一个节点和纵向的一个节点
 * .——.
 * |
 * .
 * 状态转移方程为f(m,n) = f(m + 1,n) + f(m,n + 1) + 1
 * 最后需要对节点进行如下判断：
 * 1.边界判断，不能纵向行数不能超过m,列数不能超过n，故加入p,q这两个参数
 * 2.剪枝判断，对于已经访问过的节点不再访问，避免重复计算，故加入visited这个二维数组进行记录访问情况
 */
public class Solution1 {
    public int movingCount(int m, int n, int k){
        //用于剪枝，判断是否已经访问过
        boolean[][] visited = new boolean[m][n];
        return getCount(0,0,m - 1,n - 1,k,visited);
    }

    private int getCount(int m, int n,int p, int q, int k,boolean[][] visited){
        //初始值，就是（0，0）
        if(k == 0){
            return 1;
        }
        //判断边界
        if(m <= p && n <= q){
            //行列数位和不大于k,并且没有访问过
            if((m / 10 + m % 10  + n / 10  + n % 10) <= k && !visited[m][n]){
                //访问后标记上
                visited[m][n] = true;
                //核心部分，f(m,n) = f(m + 1,n) + f(m,n + 1) + 1
                return getCount(m +1,n,p,q,k,visited) + getCount(m,n + 1,p,q,k,visited) + 1;
            }else{
                //行列数位和大于k或者已经访问过，都返回0
                return 0;
            }
        }else{
            //超出边界，返回0
            return 0;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int i = solution.movingCount(2, 3, 1);
        System.out.println(i);
    }
}
