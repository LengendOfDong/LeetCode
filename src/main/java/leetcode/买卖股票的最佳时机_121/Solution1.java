package leetcode.买卖股票的最佳时机_121;

/**
 * @author dadongge
 * @date 2020/3/9
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if( (i + 1) < prices.length && prices[i + 1] <= prices[i]){
                continue;
            }
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxProfit(prices));
    }
}
