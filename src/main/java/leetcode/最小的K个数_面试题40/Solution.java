package leetcode.最小的K个数_面试题40;

import java.util.Arrays;

/**
 * @author dadongge
 * @date 2020/3/20
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int[] array = new int[k];
        System.arraycopy(arr, 0, array, 0, k);
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{3, 2, 1};
        int[] leastNumbers = solution.getLeastNumbers(arr1, 2);
        System.out.println(Arrays.toString(leastNumbers));
        int[] arr2 = new int[]{0, 1, 2, 1};
        int[] leastNumbers1 = solution.getLeastNumbers(arr2, 1);
        System.out.println(Arrays.toString(leastNumbers1));
    }
}
