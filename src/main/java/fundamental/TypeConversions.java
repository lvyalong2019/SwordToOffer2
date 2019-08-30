package fundamental;

public class TypeConversions {

    /**
     * 总结：
     * toString:将数据转换成字符串（例子：Integer.toString，整型转字符串）
     * valueOf:字符串与数值之间的转换（例子：String.valueOf（）将某类型转字符串，Interger.valueOf（String）将字符串转整型）
     */

    public static void main(String[] args){
        intToString();
//        stringToInt();
    }

    /**
     * 数据类型转换
     */
    public static int stringToInt(){//字符串转整型
        String a = "123";
        String b = "123";
        int i = Integer.parseInt(a);
        int j = Integer.valueOf(b);

        System.out.println(a + b);

        return i;
    }

    public static int intToString(){//整型转字符串
        int i = 123;
        int j = 123;
        String a = String.valueOf(i);
        String b = Integer.toString(j);
        String c = "" + i;

        System.out.println(i + j + i);
        System.out.println(i + j + c);
        System.out.println(a + b);
        System.out.println(c);

        return i;
    }

}
