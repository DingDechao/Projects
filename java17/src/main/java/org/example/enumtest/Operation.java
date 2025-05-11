package org.example.enumtest;

public enum Operation {

    PLUS {
        public  double eval(double x, double y) {
            return x + y;
        }
    };


    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 4));
    }
}
