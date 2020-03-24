package leetcode.最长回文串_409;

/**
 * @author dadongge
 * @date 2020/3/19
 */
public class Solution1 {
    public int longestPalindrome(String s){
        int[] count = new int[128];
        for(char ch: s.toCharArray()){
            count[ch]++;
        }

        int ans = 0;
        for(int v : count){
            ans += v /2 * 2;
            //加1之后就不再是偶数，所以只取了第一个为奇数的情况
            if(v % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int abbbcccdd = solution1.longestPalindrome("abbbcccdd");
        System.out.println(abbbcccdd);
    }
}
