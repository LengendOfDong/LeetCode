package leetcode.卡牌分组_914;

import java.util.*;

/**
 * @author dadongge
 * @date 2020/3/27
 */
public class Solution {
    public boolean hasGroupsSize(int[] deck){
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        int g = -1;
        for(int i = 0; i<10000; ++i){
            if(count[i] > 0 ){
                if(g == -1){
                    g = count[i];
                }else{
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }

    private int gcd(int x, int y){
        return x == 0? y : gcd(y % x, x);
    }


    private int getCommonDivisor(int num1,int num2){
        return (num1 % num2 == 0) ? num2 : getCommonDivisor(num2, num1 % num2);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] deck = new int[]{1,2,3,4,4,3,2,1};
        boolean b = solution.hasGroupsSize(deck);
        System.out.println(b);
        int[] deck1 = new int[]{1,1,1,2,2,2,3,3};
        boolean b1 = solution.hasGroupsSize(deck1);
        System.out.println(b1);
        int[] deck2 = new int[]{1};
        boolean b2 = solution.hasGroupsSize(deck2);
        System.out.println(b2);
        int[]  deck3 = new int[]{1,1};
        boolean b3 = solution.hasGroupsSize(deck3);
        System.out.println(b3);
        int[] deck4 = new int[]{1,1,2,2,2,2};
        boolean b4 = solution.hasGroupsSize(deck4);
        System.out.println(b4);
        int[] deck5 = new int[]{1,1,1,1,2,2,2,2,2,2};
        boolean b5 = solution.hasGroupsSize(deck5);
        System.out.println(b5);
    }
}
