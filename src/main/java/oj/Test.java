package oj;

import java.util.*;

/**
 * @author dadongge
 * @date 2020/4/1
 */
public class Test {
    public static void main(String[] args){
//        Integer i1 = 127;
//        Integer i2 = 127;
//        System.out.println(i1 == i2);
//        Integer j1 = new Integer(10);
//        Integer j2 = new Integer(10);
//        System.out.println(j1 == j2);
//        String str1 = "123";
//        String str2 = "123";
//        System.out.println(str1 == str2);
//        String str3 = new String("123");
//        String str4 = new String("123");
//        System.out.println(str3 == str4);
        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(1,2);
        map.put(3,4);
        map.put(5,7);
        System.out.println(map);
        Integer remove = map.remove(1);
        map.put(1,remove);
        System.out.println(map);
        Map<Integer,Integer> newMap = new LinkedHashMap<>();
        newMap.put(7,9);
        newMap.putAll(map);
        System.out.println(newMap);
        map = newMap;
        System.out.println(map);
    }
}
