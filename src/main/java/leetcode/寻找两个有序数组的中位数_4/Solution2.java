package leetcode.寻找两个有序数组的中位数_4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dadongge
 * @date 2020/3/1
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer,Integer> finalMap = new HashMap<>();
        double median = 0.0;
        for(int i=0,j=0;i < nums1.length || j < nums2.length ; ){
            if(i >= nums1.length && j < nums2.length){
                putInMap(nums2[j], finalMap);
                j++;
            }
            if(j >= nums2.length && i < nums1.length){
                putInMap(nums1[i], finalMap);
                i++;
            }
            if(i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    putInMap(nums1[i] , finalMap);
                    i++;
                } else {
                    putInMap(nums2[j] , finalMap);
                    j++;
                }
            }
        }
        System.out.println(finalMap);
        return 0;
    }

    private void putInMap(int key, Map<Integer, Integer> finalMap) {
        if(finalMap.containsKey(key)){
            finalMap.put(key,finalMap.get(key) + 1);
        }else {
            finalMap.put(key, 1);
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,2};
        int[] nums2 = new int[]{3,4};
        Solution2 solution = new Solution2();
        solution.findMedianSortedArrays(nums1,nums2);
    }
}
