package leetcode.地图分析_1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二维表格上的问题，常用的算法是深度优先遍历、广度优先遍历和并查集，由于这里计算的结果和距离相关，显然使用
 * 广度优先遍历
 * 二维表格上编码代码的常用技巧：
 * 1.设置方向数组，使得向"四面八方"扩散的代码更加紧凑
 * 2.设置是否越界的判断函数inArea();
 * 3.根据情况，使用二维坐标和一维坐标相互转换的操作，因为二维坐标传入队列的时候，需要封装成数组，创建和销毁数组
 * 有一定的性能消耗，有些问题如果需要判重，还可能有一点点工作量。
 * @author dadongge
 * @date 2020/3/30
 */
public class Solution {
        public int maxDistance(int[][] grid) {
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            Queue<int[]> queue = new ArrayDeque<>();
            int m = grid.length, n = grid[0].length;
            // 先把所有的陆地都入队。
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[] {i, j});
                    }
                }
            }

            // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
            boolean hasOcean = false;
            int[] point = null;
            while (!queue.isEmpty()) {
                point = queue.poll();
                int x = point[0], y = point[1];
                // 取出队列的元素，将其四周的海洋入队。
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                    hasOcean = true;
                    queue.offer(new int[] {newX, newY});
                }
            }

            // 没有陆地或者没有海洋，返回-1。
            if (point == null || !hasOcean) {
                return -1;
            }

            // 返回最后一次遍历到的海洋的距离。
            return grid[point[0]][point[1]] - 1;

        }

}
