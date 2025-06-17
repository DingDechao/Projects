package org.example.thread;

import java.util.Date;

public class SleepTest0 {
    public static void main(String[] args) throws Exception {
        for (var i = 0; i < 10; i++) {
            System.out.println("Current Date=" + new Date());
            Thread.sleep(1_000);
        }
    }
}
