package leetcode.寻找两个有序数组的中位数_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dadongge
 * @date 2020/3/1
 */
public class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        double median = 0.0d;
        for(int i=0,j=0;i < nums1.length || j < nums2.length ; ){
            if(i >= nums1.length && j < nums2.length){
                putInList(nums2[j], numList, countList);
                j++;
            }
            if(j >= nums2.length && i < nums1.length){
                putInList(nums1[i], numList, countList);
                j++;
            }
            if(i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    putInList(nums1[i],numList,countList);
                    i++;
                } else {
                    putInList(nums2[j],numList,countList);
                    j++;
                }
            }
        }
        System.out.println(numList);
        System.out.println(countList);
        System.out.println(10.0 / 4.0);
        if( numList.size() % 2 == 0){
            median = (numList.get(numList.size() / 2 - 1) * countList.get(numList.size() / 2 -1) + numList.get(numList.size() / 2) * countList.get(numList.size() /2 )) /  ((countList.get(numList.size() / 2 -1) + countList.get(numList.size() /2 )) * 1.0);
        }else {
            median = (numList.get(numList.size() / 2)) / countList.get(numList.size() / 2);
        }
        return median;
    }

    private void putInList(int o, List<Integer> numList, List<Integer> countList) {
        if(numList.contains(o)){
            countList.set(numList.indexOf(o),countList.get(numList.indexOf(o)) + 1);
        }else{
            numList.add(o);
            countList.add(1);
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,2};
        int[] nums2 = new int[]{3,3,4};
        Solution3 solution = new Solution3();
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
