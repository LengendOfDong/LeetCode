package leetcode.合并区间_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dadongge
 * @date 2020/4/17
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        //进行排序
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        //也可以使用Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int len = intervals.length;

        for(int i= 0; i < len ; i++ ){
            int[] current = intervals[i];

            int[] peek = res.get(res.size() - 1);

            if(current[0] <= peek[1]){
                //这里还需要判断尾部值的大小，是完全重叠还是部分重叠
                peek[1] = Math.max(peek[1], current[1]);
            }else{
                //不重叠的情况
                res.add(current);
            }

            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
