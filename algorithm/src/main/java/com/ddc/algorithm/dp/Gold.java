package com.ddc.algorithm.dp;

import java.util.Arrays;

public class Gold {


    // restPeople: 剩余的人数
    // resetGold: 剩余的金矿
    // gold: 几个金矿
    // people: 每个金矿需要的人数
    public static int process(int restPeople, int resetGold, int[] gold, int[] people) {
        if (restPeople == 0 || resetGold == 0) {
            return 0;
        }
        if (restPeople < people[resetGold - 1]) {
            return process(restPeople, resetGold - 1, gold, people);
        }
        return Math.max(process(restPeople, resetGold - 1, gold, people), gold[resetGold - 1] + process(restPeople - people[resetGold - 1], resetGold - 1, gold, people));
    }


    // restPeople: 剩余的人数
    // resetGold: 剩余的金矿
    // gold: 几个金矿
    // people: 每个金矿需要的人数
    public static int process1(int restPeople, int resetGold, int[] gold, int[] people) {

        int[][] dp = new int[resetGold + 1][restPeople + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < people[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], gold[i - 1] + dp[i - 1][j - people[i - 1]]);
                }
            }
        }

        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        return dp[resetGold][restPeople];

    }


    // restPeople: 剩余的人数
    // resetGold: 剩余的金矿
    // gold: 几个金矿
    // people: 每个金矿需要的人数
    public static int process2(int restPeople, int resetGold, int[] gold, int[] people) {

        int[] dp = new int[restPeople + 1];
        for (int i = 1; i <= gold.length; i++) {
            for (int j = restPeople; j > 0; j--) {
                if (j >= people[i - 1]) {
                    dp[j] = Math.max(dp[j], gold[i - 1] + dp[j - people[i - 1]]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[restPeople];

    }


    public static void main(String[] args) {
        int[] gold = {400, 500, 200, 300, 350};
        int[] people = {5, 5, 3, 4, 3};
        int restPeople = 10;
        int resetGold = gold.length;
        System.out.println(process(restPeople, resetGold, gold, people));
        System.out.println(process1(restPeople, resetGold, gold, people));
        System.out.println(process2(restPeople, resetGold, gold, people));
    }
}
