package Chapter_03;

/**
 * 正则表达式的匹配
 */

public class Test19 {

    /**
     * 解法1：比较时的几种情况
     * 1、匹配或者模式为‘.’
     * 2、模式第二个为‘*’
     *   2.1、匹配，模式加2
     *   2.2、匹配，模式不变
     *   2.3、模式加2，再匹配
     */

    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        int length1 = str.length;
        int length2 = pattern.length;
        return matchCore(str,length1,0,pattern,length2,0);
    }

    public static boolean matchCore(char[] str, int length1, int index1, char[] pattern,int length2, int index2) {
        if (index1 == length1 && index2 == length2)
            return true;
        if (index1 != length1 && index2 == length2)
            return false;

        if (index2 < length2-1) {
            if (pattern[index2 + 1] == '*') {
                if (index1 == length1)
                    return matchCore(str,length1,index1,pattern,length2,index2+2);
                if (pattern[index2]=='.' || str[index1] == pattern[index2])
                    return matchCore(str,length1,index1+1,pattern,length2,index2+2)
                            ||matchCore(str,length1,index1+1,pattern,length2,index2)
                            ||matchCore(str,length1,index1,pattern,length2,index2+2);
                else
                    return matchCore(str,length1,index1,pattern,length2,index2+2);
            }
        }
        if (index1 == length1)
            return false;

        if (str[index1] == pattern[index2] || pattern[index2] == '.')
            return matchCore(str,length1,index1+1,pattern,length2,index2+1);
        return false;
    }

    public static boolean match2(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }

}
