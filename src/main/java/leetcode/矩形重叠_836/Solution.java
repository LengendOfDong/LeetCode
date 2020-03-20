package leetcode.矩形重叠_836;

/**
 * @author dadongge
 * @date 2020/3/20
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]);
    }

    public static void main(String[] args){
        int[] rec1 = new int[]{-7,-3,10,5};
        int[] rec2 = new int[]{-6,-5,5,10};
        Solution solution = new Solution();
        boolean rectangleOverlap = solution.isRectangleOverlap(rec1, rec2);
        System.out.println(rectangleOverlap);
    }
}
