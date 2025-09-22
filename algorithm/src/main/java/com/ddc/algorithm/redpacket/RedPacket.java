package com.ddc.algorithm.redpacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacket {
    // N个人抢M元红包, 每个人至少抢到1分钱, 每个人抢到的金额随机
    // 返回每个人抢到的金额数组
    public double[] redPacket(int n, double m) {
        if (n < 1) {
            return null;
        }
        double[] result = new double[n];
        // 为了让每个人抢到的钱尽可能平均, 给每个人随机分配的金额为 m/n * 2
        double limit = m / n * 2;
        for (int i = 0; i < n - 1; i++) {
            double amount = Math.random() * limit;
            while (amount > m) {
                amount = Math.random() * limit;
            }
            result[i] = Math.max(0.01, amount);
            m -= result[i];
        }
        result[n - 1] = m;
        return result;
    }

    // 以分带单位, 每次能随机到的金额都是 [1,总余额 / 剩余人数 * 2] 之间
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            // 保证每个人至少分到1分钱
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            amountList.add(amount);
            restAmount -= amount;
            restPeopleNum--;
        }
        amountList.add(restAmount);
        return amountList;

    }

    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
        double[] result = redPacket.redPacket(10, 100);
        double sum = 0;
        for (double d : result) {
            System.out.println(d);
            sum += d;
        }
        System.out.println("sum: " + sum);

        List<Integer> list = divideRedPackage(100, 10);
        int sum1 = 0;
        for (Integer integer : list) {
            System.out.println(integer);
            sum1 += integer;
        }
        System.out.println("sum1: " + sum1);
    }
}
