package Chapter_02;

import java.util.Scanner;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某
 * 些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重
 * 复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出
 * 是第一个重复的数字2或者3。
 */

/**
 * 测试用例：
 * 长度为n的数组里包含一个或多个重复的数字
 * 数组不包含重复的数字（1 2 3 4 4 5 6 7 ）（2 3 5 4 3 2 6 7）
 * 无效测试用例（空数组或长度为n的数组中包含0~n-1之外的数字）（1 2 3 4）
 */

public class Test03Q1 {

    public static void main(String[] args) {
        //用此方法可以不用预设数组大小
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组");
        String a = in.nextLine();
        if (a.isEmpty()){
            System.out.println("输入数组为空");
            System.exit(1);
        }

        String [] b = a.split(" ");
        int length = b.length;
        int [] c = new int[15];
        for (int i = 0;i < length; i++){
            c[i] = Integer.valueOf(b[i]);
        }

        int dupilcation = 0;
        dupilcation = duplicate2(c,length,dupilcation);
        if (dupilcation == -1)
            System.out.println("数组中没有重复数字");

        else if (dupilcation != 0)
            System.out.println(dupilcation);
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (numbers == null || length <= 0)
            return false;

        for (int i = 0;i < length;i++){
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }

        for (int i = 0;i < length;i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                else{
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }

        return false;
    }

    public static int duplicate2(int numbers[],int length,int duplication) {

        for (int i = 0;i < length;i++){
            if (numbers[i] < 0 || numbers[i] > length - 1){
                System.out.println("输入数字不在规定范围内");
                return duplication;
            }
        }

        for (int i = 0;i < length;i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication = numbers[i];
                    return duplication;
                }
                else{
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }

        duplication = -1;
        return duplication;
    }

}
