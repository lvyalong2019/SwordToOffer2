package Chapter_02;

import java.util.Scanner;

/*替换空格*/

public class Test05 {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入字符串");
        String inputstr = in.nextLine();
        StringBuffer str = new StringBuffer(inputstr);
        str = ReplaceBlank(str);
        System.out.println(str);
    }

    public static StringBuffer ReplaceBlank(StringBuffer str) {

//        求原字符串和修改后字符串长度
        int P1 = str.length() - 1;
        for (int i = 0;i <= P1;i++) {
            if (str.charAt(i) == ' ')
                str.append("  ");
        }
        int P2 = str.length() - 1;

//        用20%替换空格
        while (P1 < P2) {
            if (str.charAt(P1) == ' ') {
                str.setCharAt(P2--,'0');
                str.setCharAt(P2--,'2');
                str.setCharAt(P2--,'%');
            }else {
                str.setCharAt(P2--,str.charAt(P1));
            }
            P1--;
        }

        return str;
    }

}
