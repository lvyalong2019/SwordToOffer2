package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。



 Input Param

 n               输入随机数的个数

 inputArray      n个随机整数组成的数组


 Return Value

 OutputArray    输出处理后的随机整数



 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 */

public class SortAndDuplicateRemoval {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int length = in.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = in.nextInt();
            }

            Arrays.sort(array);
            for(int i = 0; i < length; i++) {
                if (i < length-1 && array[i] == array[i + 1])
                    continue;
                System.out.println(array[i]);
            }
        }
    }

//    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        while(s.hasNextInt()){
//            int count = s.nextInt();
//            // ArrayList<Integer> array = new ArrayList<Integer>();
//            int[] array = new int[count];
//            for(int i=0; i<count; i++){
//                array[i] = s.nextInt();
//            }
//            Arrays.sort(array);
//            int[] temp = new int[1000];
//            for(int i=0; i<count; i++){
//                temp[array[i]] = 1;
//            }
//            for(int i=0; i<1000; i++){
//                if(temp[i] == 1){
//                    System.out.println(i);
//                }
//            }
//        }
//    }


}