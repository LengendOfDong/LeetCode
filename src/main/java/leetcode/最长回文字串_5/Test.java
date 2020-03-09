package leetcode.最长回文字串_5;

/**
 * @author dadongge
 * @date 2020/3/3
 */
public class Test {
    public String longestPalindrome(String s) {
        String longestReverseStr = "";
        String middle;
        if(s.length() == 1){
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(s.length()-1)){
                return s;
            }else {
                return String.valueOf(s.charAt(0));
            }
        }
        for(int i= 1;i < s.length()-1 ; i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i + 1);
            String str;
            if(s1.charAt(s1.length() - 1) == s2.charAt(0)){
//                middle = s1.charAt(s1.length() - 1) + String.valueOf(s.charAt(i)) + s2.charAt(0);
                if(s1.length() >= 1 && s2.length() >= 1){
                    str = getStr(String.valueOf(s.charAt(i)), s1, s2);
                }else{
                    str = s1.charAt(s1.length() - 1) + String.valueOf(s.charAt(i)) + s2.charAt(0);
                }
            }else {
                if(s2.charAt(0) == s.charAt(i)){
                    middle = String.valueOf(s.charAt(i)) + s2.charAt(0);
                    if(s2.length() > 1){
                        s2 = s2.substring(1);
                        str = getStr(middle, s1, s2);
                    }else{
                        str = middle;
                    }
                }else if(s1.charAt(s1.length() - 1) == s.charAt(i)){
                    middle = s1.charAt(s1.length() - 1) + String.valueOf(s.charAt(i));
                    if(s1.length() > 1){
                        s1 = s1.substring(0,s1.length() - 1);
                        str = getStr(middle, s1, s2);
                    }else{
                        str = middle;
                    }
                }else {
                    str = String.valueOf(s.charAt(i));
                }
            }
            if(longestReverseStr.length() <= str.length()){
                longestReverseStr = str;
            }
        }
        return longestReverseStr;
    }

    public String getStr(String s,String s1,String s2){
        if(s1.length() >1 && s2.length() > 1) {
            if(s1.charAt(s1.length() - 1) == s2.charAt(0)) {
                s = s1.charAt(s1.length() - 1) + s + s2.charAt(0);
                s1 = s1.substring(0, s1.length() - 1);
                s2 = s2.substring(1);
            }else {
                return s;
            }
        }else{
            if(s1.charAt(s1.length() - 1) == s2.charAt(0)){
                s = s1.charAt(s1.length() - 1) + s + s2.charAt(0);
            }
            return s;
        }
        return getStr(s,s1,s2);
    }

    public static void main(String[] args){
        Test solution = new Test();
//        List<String> array = Arrays.asList("a","ab","aa","aba","aaa","aab","baa","abc","abcd","abba","abbc","aabc","bcaa","bacab","bacad","aaaa");
//        for(String str:array){
//            String s = solution.longestPalindrome(str);
//            System.out.println(s);
//        }
        String s = solution.longestPalindrome("aaaa");
        System.out.println(s);
    }
}
