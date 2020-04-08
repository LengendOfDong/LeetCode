package oj;

/**
 * @author dadongge
 * @date 2020/4/1
 */
public class Test1 {
    public static void main(String[] args){
        Integer i = 3;
        System.out.println(i);
        test(i);
        System.out.println(i);
    }

    private static void test(Integer i){
        i = 3 * i;
        System.out.println("test :" + i);
    }
}
