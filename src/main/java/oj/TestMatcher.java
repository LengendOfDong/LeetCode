package oj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dadongge
 * @date 2020/4/10
 */
public class TestMatcher {
    public static void main(String[] args){
        String s = "one  dog  two  dogs  in  the  yard";
        String regex = "\\S";
        StringBuffer sb = new StringBuffer(" ");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            matcher.appendTail(sb);
        }
        System.out.println(sb);

    }
}
