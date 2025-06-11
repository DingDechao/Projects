package org.example.java11.basic;

public abstract class Interest {

    public double getinterest(double value) {
        double lixi = 0;
        double interestRate = 0;
        interestRate = getInterestRate();
        lixi = value * interestRate;
        return lixi;
    }

    public abstract double getInterestRate();
}
