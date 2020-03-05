package leetcode.分糖果II_1103;

/**
 * @author dadongge
 * @date 2020/3/5
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int m = 1;
        for( ;num_people * m * (num_people * m  + 1) / 2 < candies ; m++){

        }
        int count = 0;
        int[] arr = new int[num_people];
        while(count < m - 1){
            for(int i = 0; i < arr.length ; i++){
                arr[i] = count * num_people + (i + 1) + arr[i];
                candies = candies - (count * num_people+ (i + 1));
            }
            count++ ;
        }
        for(int i= 0 ; i < arr.length; i++){
            if(count * num_people + (i + 1) >= candies){
                arr[i] =  candies + arr[i];
                break;
            }else{
                arr[i] = count * num_people + (i + 1) + arr[i];
                candies = candies - (count * num_people + (i + 1));
            }
        }
        return arr;
    }
}
