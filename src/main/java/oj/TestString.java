package oj;

/**
 * @author dadongge
 * @date 2020/4/1
 */
public class TestString {
    public static void main(String[] args){
        String str = "1234";
        StringBuffer sb = new StringBuffer("2345");
        System.out.println(str);
        System.out.println(sb);
        modifyString(str);
        modifyStringBuffer(sb);
        System.out.println(str);
        System.out.println(sb);
    }

    private static void modifyString(String str){
        str = str + "123";
        System.out.println("str = " + str);
    }

    private static void modifyStringBuffer(StringBuffer sb){
        sb.append("678");
        System.out.println("sb = " + sb);
    }
}
