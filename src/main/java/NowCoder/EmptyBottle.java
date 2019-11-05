package NowCoder;

import java.util.Scanner;

/**
 * 换空瓶子：3和空瓶子换一瓶酒
 */

public class EmptyBottle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        String str = "";
        while (temp != 0){
            str = str + temp + " ";
            temp = in.nextInt();
        }
        if (str.length() <= 0)
            return;
        String[] arrayTemp = str.split(" ");

        int length = arrayTemp.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.valueOf(arrayTemp[i]);
            array[i] = array[i] / 2;
//            int num = 0;
//            while(array[i] >= 3) {
//                num = num + array[i] / 3;
//                array[i] = array[i] / 3 + array[i] % 3;
//            }
//            if (array[i] == 2)
//                num ++;
//            array[i] = num;
        }

        for(int i = 0; i < length; i++)
            System.out.println(array[i]);


    }

}
