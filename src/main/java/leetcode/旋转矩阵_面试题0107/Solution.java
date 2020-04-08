package leetcode.旋转矩阵_面试题0107;

import java.util.Arrays;

/**
 * @author dadongge
 * @date 2020/4/7
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = i; j<len - 1 - i; j++){
                int temp = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args){
//        int[][] matrix = new int[3][3];
//        matrix[0] = new int[]{1,2,3};
//        matrix[1] = new int[]{4,5,6};
//        matrix[2] = new int[]{7,8,9};
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        Solution solution = new Solution();
        solution.rotate(matrix);
        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}
