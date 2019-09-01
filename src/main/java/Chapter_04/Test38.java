package Chapter_04;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 打印字符串全排列
 */

public class Test38 {

//    static ArrayList<String> ret = new ArrayList<>();
//    public static ArrayList<String> permutation (String str) {
//        if (str == null || str.length() == 0)
//            return null;
//
//        char[] chars = str.toCharArray();
//        int length = chars.length;
//        permutationCore(chars,length,0);
//        return  ret;
//    }
//
//    private static void permutationCore (char[] chars, int length, int start) {
//        if (chars == null || chars.length == 0)
//            return;
//
//        int index = start;
//        if (index == length-1){
//            String str = Arrays.toString(chars);
//            ret.add(str);
//            return;
//        }
//
//        for (int i = index; i < length; i++) {
//            char temp = chars[index];
//            chars[index] = chars[i];
//            chars[i] = temp;
//            permutationCore(chars,length,index+1);
//            temp = chars[index];
//            chars[index] = chars[i];
//            chars[i] = temp;
//        }
//    }

//    static ArrayList<String> ret = new ArrayList<>();
//    public static ArrayList<String> permutation (String str) {
//        if (str == null || str.length() == 0)
//            return null;
//
//        char[] chars = str.toCharArray();
//        int length = chars.length;
//        permutationCore(chars,length,0);
//        return  ret;
//    }
//
//    private static void permutationCore (char[] chars, int length, int start) {
//        if (chars == null || chars.length == 0)
//            return;
//
//        int index = start;
//        if (index == length-1){
//            String str = Arrays.toString(chars);
//            str = str.substring(1,str.length());
//            str = str.replace(",","");
//            str = str.replace(" ","");
//            ret.add(str);
//            return;
//        }
//
//        permutationCore(chars,length,index+1);
//        for (int i = index + 1; i < length; i++) {
//            if (chars[index] == chars[i])
//                continue;
//            char temp = chars[index];
//            chars[index] = chars[i];
//            chars[i] = temp;
//            permutationCore(chars,length,index+1);
//            temp = chars[index];
//            chars[index] = chars[i];
//            chars[i] = temp;
//        }
//    }

//    static ArrayList<String> ret = new ArrayList<>();
//    public static ArrayList<String> permutation (String str) {
//        if (str == null)
//            return null;
//
//        char[] chars = str.toCharArray();
//        int length = chars.length;
//        permutationCore(chars,length,0,new StringBuilder());
//        return  ret;
//    }
//
//    private static void permutationCore (char[] chars, int length, int start,StringBuilder str) {
//        if (chars == null)
//            return;
//
//        int index = start;
//        if (index == length-1){
//            str.append(chars[index]);
//            ret.add(str.toString());
//            str.deleteCharAt(str.length() - 1);
//            return;
//        }
//
//        for (int i = index; i < length; i++) {
//            if (chars[index] == chars[i] && index != i)
//                continue;
////            char temp = chars[index];
////            chars[index] = chars[i];
////            chars[i] = temp;
//            str.append(chars[i]);
//            permutationCore(chars,length,index+1,str);
//            str.deleteCharAt(str.length() - 1);
////            temp = chars[index];
////            chars[index] = chars[i];
////            chars[i] = temp;
//        }
//    }

    private static ArrayList<String> ret = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

}
