package fundamental;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args){
        importIntAndString();
//        importArray();
//        distinctNumbers();
    }

    /**
     * 输入整型加字符串
     * 若先输入整型再输入字符串，当输入完整型时需要回车一次，此时程序会以为输入了一个空字符串，
     * 并将int类型的数据与空字符串一起打印出来
     */
    public static void importIntAndString(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入一个整数");
            String str1 = in.nextLine();
            int x = Integer.valueOf(str1);//字符串转整型的一种方法
//            int x = in.nextInt();
            System.out.println(x);

            System.out.println("请输入一个字符串");
            String str2 = in.nextLine();
            System.out.println(str2);
//
//            System.out.println("请输入一个字符串");
//            String str3 = in.nextLine();
//            System.out.println(str3);

//            System.out.println("请输入一个整数");
//            int x = in.nextInt();
//            System.out.println(x);
        }catch (Exception e){
            System.out.println("非法的输入");
        }

//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入一个整数");
//        String str1 = in.nextLine();
//        int x = Integer.parseInt(str1);
//        System.out.println(x);
//
//        System.out.println("请输入一个字符串");
//        String str2 = in.nextLine();
//        System.out.println(str2);

    }

    /**
     * 输入数组
     * 测试用例：1 2 3 4 5 6 7 8
     */
    public static void importArray(){
        try {
            int arraylength = 8;
            int a[] = new int[arraylength];
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入长度为8的数组，并以回车结束：");
            for(int i = 0;i < arraylength;i++){
                a[i] = sc.nextInt();
            }
            //直接打印数组a出来的是数组的首地址，必须用toString方法
            System.out.println("数组为：" + Arrays.toString(a));//数组转字符串
            String st = Arrays.toString(a);
//            for (int i:a)
//                System.out.println(i);
        }catch (Exception e){
            System.out.println("输入错误");
        }
    }

    /**
     * ArrayList
     * java.util.ArrayList<E> 是非常重要的一个类，在代码中广泛使用，E表示泛型，ArrayList是一个泛型类。
     * ArrayList相当于C++ 的vector，用于存储对象。与数组不同，数组一旦创建，长度固定，
     * 但是ArrayList的长度是动态的，不受限制，可以存储任意多的对象，但是只能存储对象，不能存储原生数据类型例如int。
     *
     * 由于ArrayList只能存储对象，不能存储原生数据类型数据，下面的代码是错误的：
     * ArrayList<int> list = new ArrayList<>(); 错误！！！！！
     * 只能写成：
     * ArrayList<Integer> list = new ArrayList<>();
     *
     * 原文链接：https://blog.csdn.net/ftell/article/details/80826235
     */
    public static void distinctNumbers() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int value;
        do {
            value = input.nextInt(); // Read a value from the input
            if (!list.contains(value) && value != 0)
                list.add(value); // Add the value if it is not in the list
        } while (value != 0);
        // Display the distinct numbers
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }

}
