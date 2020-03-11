package leetcode.将数组分成和相等的三个部分_1013;

/**
 * @author dadongge
 * @date 2020/3/11
 */
public class Solution{
    public boolean canThreePartsEqualSum(int[] A) {
        int totality = 0;
        int sum = 0;
        int group = 0;
        for (int i = 0; i < A.length; i++) {
            totality = totality + A[i];
        }
        if (totality % 3 == 0) {
            int count = totality / 3;
            for (int i = 0; i < A.length; i++) {
                sum = sum + A[i];
                if (sum == count && group < 2) {
                    group++;
                    sum = 0;
                }
            }
            if (sum == totality / 3) {
                return true;
            }
        }
        return false;
    }
}
