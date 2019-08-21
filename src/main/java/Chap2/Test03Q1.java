package Chap2;


/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某
 * 些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重
 * 复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出
 * 是第一个重复的数字2或者3。
 */
/*
 * 测试用例：
 * 长度为n的数组里包含一个或多个重复的数字
 * 数组不包含重复的数字
 * 无效测试用例（空数组或长度为n的数组中包含0~n-1之外的数字）
 */

public class Test03Q1 {

    public class main{

    }

    public boolean duplicate(int numbers[],int length,int [] duplication){

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

}
