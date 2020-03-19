package leetcode.拼写单词_1160;

/**
 * @author dadongge
 * @date 2020/3/18
 */
public class Solution1 {
    public int countCharacters(String[] words,String chars){
        int count = 0;
        for(String str:words){
            boolean aBoolean = getBoolean(str, chars);
            if(aBoolean){
                count = count + str.length();
            }
        }
        return count;
    }

    private boolean getBoolean(String str, String string) {
        for(int i=0;i<str.length();i++){
            int index = string.indexOf(str.charAt(i));
            if( index != -1 ){
                if(string.length() == 1) {
                    string = "";
                }else {
                    if(index == 0) {
                        string = string.substring(index + 1);
                    }else if(index == string.length() - 1){
                        string = string.substring(0,string.length() - 1);
                    }else{
                        string = string.substring(0,index) + string.substring(index + 1);
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] words = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        Solution1 solution = new Solution1();
        int i = solution.countCharacters(words, chars);
        System.out.println(i);
    }
}
