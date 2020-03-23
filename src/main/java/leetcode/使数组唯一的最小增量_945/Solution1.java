package leetcode.使数组唯一的最小增量_945;

/**
 * @author dadongge
 * @date 2020/3/22
 */
public class Solution1 {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x: A){ count[x]++;}

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,2};
        int[] array1 = new int[]{3,2,1,2,1,7};
        Solution1 solution = new Solution1();
        int count = solution.minIncrementForUnique(array);
        System.out.println(count);
        int count1 = solution.minIncrementForUnique(array1);
        System.out.println(count1);
    }
}
