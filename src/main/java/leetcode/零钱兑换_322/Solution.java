package leetcode.零钱兑换_322;

import java.util.*;

/**
 * @author dadongge
 * @date 2020/3/8
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : coins){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> report = new ArrayList<>();
        getCount(list,0,amount,0, report);
        Collections.sort(report);
        return report.get(0);
    }

    private int getCount(List<Integer> list, int i,int amount,int total, List<Integer> report){
        if(i < list.size()) {
            if (amount % list.get(i) == 0) {
                int num = total + amount / list.get(i);
                report.add(num);
            } else {
                int cycle = amount / list.get(i);
                while (cycle >= 0) {
                    int remain = amount - list.get(i) * cycle;
                    int index = i + 1;
                    int s = total + cycle;
                    getCount(list, index, remain, s,report);
                    cycle--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] coins = new int[]{227,99,328,299,42,322};
//        int[] coins = new int[]{1,2,5};
        Solution solution = new Solution();
        int i = solution.coinChange(coins, 9847);
        System.out.println(i);
    }
}
