package com.ddc.algorithm.kmp;

// KMP算法
// KMP算法是一种字符串匹配算法，时间复杂度为O(N)，其中N为文本串长度
// KMP算法的核心思想是利用已经匹配过的信息，避免重复匹配。
public class Kmp {

    public static int getIndexOf(String str, String match) {
        if (str == null || match == null || match.length() < 1 || str.length() < match.length()) {
            return -1;
        }
        char[] strChars = str.toCharArray();
        char[] matchChars = match.toCharArray();
        int i1 = 0; // str的指针
        int i2 = 0; // match的指针
        int[] next = getNextArray(match);
        while (i1 < strChars.length && i2 < matchChars.length) {
            if (strChars[i1] == matchChars[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) { // 如果i2已经移动到0位置了, 那么i1继续往后移动
                i1++;
            } else { // 如果不相等, 那么i2回退到前后缀的最大长度位置
                i2 = next[i2];
            }
        }
        return i2 == matchChars.length ? i1 - i2 : -1;
    }

    // 创建一个函数, 接受需要匹配的字符串作为参数,返回这个字符串的相同长度的前后缀数组,假设当前位置为i,那么next[i]表示0~i-1位置的字符串的前后缀的最大长度
    // 字符串 aabbc
    // i = 0, next[0] = -1 a : a前面没有任何字符,所以人为规定返回-1
    // i = 1, next[1] = 0 aa : a前面只有一个字符a, 人为规定, 如果需要有前后缀的长度, 那么前后缀不能是全部内容,
    // 比如 aa, i位置不算,所以只有一个a, a是全部,所以不能算长度,人为规定返回0
    // i = 2, next[2] = 1 aab : b不算,b前面有两个a, 长度为1的前缀是a, 后缀是a, 符合要求且长度为1, aa是全部不考虑,所以返回1
    // i = 3, next[3] = 0 aabb : b不算, b前面有aab, 长度为1前缀是a, 后缀是b, 不符合要求, 长度为2前缀是aa, 后缀ab, 不符合要求
    // 长度为3时全部,不考虑,所以返回0
    // i = 4, next[4] = 0 aabbc : c不算, c前面有aabb, 长度为1前缀是a, 后缀是b, 不符合要求, 长度为2的前缀时aa, 后缀是bb, 不符合要求
    // 长度为3前缀是aab, 后缀是abb, 不符合要求, 长度为4时是全部,不考虑,所以返回0
    public static int[] getNextArray(String str) {
        if (str == null || str.length() == 0) {
            return new int[]{-1};
        }
        if (str.length() == 1) {
            return new int[]{-1};
        }
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // 当前正在计算的位置
        int cn = 0; // 当前字符的前一个位置的前后缀的最大长度
        while (i < next.length) {
            // cn表示前后缀的字符串长度,前缀是chars[0..cn-1]共cn个,所以前缀的下一个位置是chars[cn]
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
                //如果不相等,并且cn不为0,那么就继续往前找,找到前缀的前一个位置的前后缀的最大长度
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                //如果不相等，且cn <=0; 说明前后缀的长度为0
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "aabbc";
        int[] next = getNextArray(str);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println("===");

        // test getIndexOf
        String str1 = "ababcabcabababd";
        String match = "ababd";
        System.out.println(getIndexOf(str1, match));
    }

}
