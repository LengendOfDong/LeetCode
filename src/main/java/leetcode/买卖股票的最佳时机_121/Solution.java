package leetcode.买卖股票的最佳时机_121;

/**
 * @author dadongge
 * @date 2020/3/9
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = new int[]{};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}
