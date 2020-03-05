package leetcode.回文数_9;

/**
 * @author dadongge
 * @date 2020/3/2
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int origin = x;
        if( x < 0 || (x !=0 && x % 10 == 0)){
            return false;
        }else {
            int reverseNum = 0;
            while(x >= 10){
                reverseNum = reverseNum * 10  + ( x % 10 );
                x = x / 10;
            }
            if(reverseNum > (Integer.MAX_VALUE - x) / 10 ){
                return  false;
            }else {
                reverseNum = reverseNum * 10 + x;
                if(reverseNum == origin){
                    return true;
                }else {
                    return false;
                }
            }

        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        boolean a = solution.isPalindrome(Integer.MAX_VALUE);
        boolean b = solution.isPalindrome(Integer.MIN_VALUE);
        boolean c = solution.isPalindrome(0);
        boolean d = solution.isPalindrome(1001);
        boolean e = solution.isPalindrome(121);
        boolean f = solution.isPalindrome(1534236469);
        boolean g = solution.isPalindrome(-121);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);

    }
}
