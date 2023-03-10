package com.ddc.projects.java11.java8.basic;

public class King extends Interest {

    public double getInterestRate() {
        //.............
        return 0.3;
    }

    public static void main(String[] args) {
        double m = 10000;
        King k = new King();
        double lixi = k.getinterest(m);
        System.out.println(lixi);
    }
}
