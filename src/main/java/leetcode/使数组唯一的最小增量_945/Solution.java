package leetcode.使数组唯一的最小增量_945;

import java.util.Arrays;

/**
 * @author dadongge
 * @date 2020/3/22
 */
public class Solution {
    public int minIncrementForUnique(int[] A){
        Arrays.sort(A);
        int count = 0;
        //使用贪心算法求局部最优解
        for(int i = 1; i < A.length ; i++){
            if(A[i] <= A[i - 1]){
                count = count + A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return  count;
    }


    public static void main(String[] args){
        int[] array = new int[]{1,2,2};
        int[] array1 = new int[]{3,2,1,2,1,7};
        Solution solution = new Solution();
        int count = solution.minIncrementForUnique(array);
        System.out.println(count);
        int count1 = solution.minIncrementForUnique(array1);
        System.out.println(count1);
    }


}
