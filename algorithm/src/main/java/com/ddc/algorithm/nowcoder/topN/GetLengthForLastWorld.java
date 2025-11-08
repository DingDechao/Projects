package com.ddc.algorithm.nowcoder.topN;

import java.util.Scanner;

// Hj1 : https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class GetLengthForLastWorld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int length = getLengthForLastWorld(s);
            System.out.println(length);
        }
    }

    public static int getLengthForLastWorld(String str) {
        if (str.isEmpty()) return 0;
        String[] strArray = str.split(" ");
        int N = strArray.length;
        if (N == 0) return 0;
        return strArray[N - 1].length();
    }
}
