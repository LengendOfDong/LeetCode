package leetcode.LFU缓存_460;

import java.util.*;

/**
 * @author dadongge
 * @date 2020/4/5
 */
public class LFUCache {

    private Map<Integer,Integer> map = new LinkedHashMap<>();
    private int capacity;

    public LFUCache(int capacity){
       this.capacity = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }else{
            Integer value = map.remove(key);
            map.put(key,value);
            return map.get(key);
        }
    }

    public void put(int key,int value){
        if(capacity > map.size()){
            map.put(key,value);
        }else{
            if(map.containsKey(key)) {
                map.put(key,map.remove(key));
            }else{
                for (Integer num : map.keySet()) {
                    map.remove(num);
                    break;
                }
                map.put(key, value);
                Map<Integer,Integer> newMap = new LinkedHashMap<>();
                newMap.put(key,value);
                newMap.putAll(map);
                map = newMap;
            }
        }
    }

    public static void main(String[] args){
//        LFUCache obj = new LFUCache(2);
//        System.out.println("null");
//        obj.put(1,1);
//        System.out.println("null");
//        obj.put(2,2);
//        System.out.println("null");
//        System.out.println(obj.get(1));
//        obj.put(3,3);
//        System.out.println("null");
//        System.out.println(obj.get(2));
//        System.out.println(obj.get(3));
//        obj.put(4,4);
//        System.out.println("null");
//        System.out.println(obj.get(1));
//        System.out.println(obj.get(3));
//        System.out.println(obj.get(4));
        LFUCache obj = new LFUCache(3);
        System.out.println("null");
        obj.put(2,2);
        System.out.println("null");
        obj.put(1,1);
        System.out.println("null");
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        obj.put(3,3);
        System.out.println("null");
        obj.put(4,4);
        System.out.println("null");
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        System.out.println(obj.get(4));
    }
}
