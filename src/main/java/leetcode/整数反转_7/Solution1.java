package leetcode.整数反转_7;

/**
 * @author dadongge
 * @date 2020/3/1
 */
public class Solution1 {
    public int reverse(int x) {
        int absX;
        if(x < 0){
            if(x == Integer.MIN_VALUE){
                return 0;
            }
           absX =  Math.abs(x);
        }else {
            absX = x;
        }
        int reverseNum = 0;
        while(absX >= 10){
           reverseNum = reverseNum * 10  + (absX % 10 );
           absX = absX / 10;
        }
        if(x < 0 ){
            reverseNum = reverseNum > (Integer.MAX_VALUE - absX + 1) / 10?  0 : (0 - (reverseNum * 10+ absX));
        }else{
            reverseNum = reverseNum > (Integer.MAX_VALUE - absX) / 10 ? 0 : (reverseNum * 10+ absX);
        }
        return reverseNum;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int a = solution.reverse(123);
        int b = solution.reverse(-123);
        int c = solution.reverse(120);
        int d = solution.reverse(1534236469);
        int e = solution.reverse(-2147483412);
        int f = solution.reverse(-2147483648);
        int h = solution.reverse(-1563847412);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(h);
    }
}
