package com.ddc.projects.java11.java8.basic;


import java.util.Arrays;
import java.util.Scanner;

public class Array2D {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much money you want to rent?");

        //Double rentMoney = scanner.nextDouble();
        Double rentMoney = 400000.0;
        System.out.println("How many years you want to rent?");
       // int rentYears = scanner.nextInt();
        int rentYears = 30;
        System.out.println("What's the currently rate?");
        //Double rate = scanner.nextDouble();
        Double rate = 3.25;
        Double[][] balances = new Double[rentYears*12][3];
        for (int i = 0; i < balances.length ;i++){
            double rateMoney = rentMoney*rate;
            for (int j =0 ; j < balances[i].length ; j++){
                if( j == 0){
                    balances[i][j]=rentMoney*rentYears*rate/100;
                }else if(j==1){
                    balances[i][j]=0.0;
                }else if(j==2){
                    balances[i][j]=rateMoney;
                }

            }
            System.out.println(Arrays.toString(balances[i]));
        }


    }
}
