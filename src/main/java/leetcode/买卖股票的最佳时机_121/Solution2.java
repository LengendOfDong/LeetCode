package leetcode.买卖股票的最佳时机_121;

/**
 * @author dadongge
 * @date 2020/3/9
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length ; i++){
            //求出最小价格
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            //与最小价格的价差，与历史最大利润比较，求出最大利润
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxProfit(prices));
    }
}
