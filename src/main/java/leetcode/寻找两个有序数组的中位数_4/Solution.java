package leetcode.寻找两个有序数组的中位数_4;

/**
 * @author dadongge
 * @date 2020/3/1
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] finalNums = new int[nums1.length + nums2.length];
        int count = 0;
        double median = 0.0;
        for(int i=0,j=0;i < nums1.length || j < nums2.length ; ){
            if(i >= nums1.length && j < nums2.length){
                finalNums[count] = nums2[j];
                count++;
                j++;
            }
            if(j >= nums2.length && i < nums1.length){
                finalNums[count] = nums1[i];
                count++;
                i++;
            }
            if(i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    finalNums[count] = nums1[i];
                    count++;
                    i++;
                } else {
                    finalNums[count] = nums2[j];
                    count++;
                    j++;
                }
            }
        }
        for(int num : finalNums){
            System.out.println(num);
        }
        if( finalNums.length % 2 == 0){
            median = (finalNums[finalNums.length / 2 - 1] + finalNums[finalNums.length / 2]) / 2.0;
        }else {
            median = (finalNums[finalNums.length / 2]) / 2.0;
        }
        return  median;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,2};
        int[] nums2 = new int[]{3,4};
        Solution solution = new Solution();
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
