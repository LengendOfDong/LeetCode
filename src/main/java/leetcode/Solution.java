package leetcode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author dadongge
 * @date 2020/3/22
 */
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] strings = line.split("");
            for(String string : strings){
                str = str + string + ",";
            }
            str = str.substring(0,str.length() -1);
            System.out.println(str);
        }
    }
}
