package leetcode.分糖果II_1103;

import java.util.Arrays;

/**
 * @author dadongge
 * @date 2020/3/5
 */
public class Solution1 {
    public int[] distributeCandies(int candies, int num_people) {
        int count = 0;
        int[] candyArray = new int[num_people];
        while(candies > 0){
            for(int i=0 ; i < num_people ; i++){
                int num = (i + 1) + count * num_people;
                candyArray[i] += Math.min(num,candies);
                candies -= num;
                if(candies <= 0){
                    break;
                }
            }
            count++;
        }
        return candyArray;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.distributeCandies(10, 3);
        System.out.println(Arrays.toString(ints));
    }
}
