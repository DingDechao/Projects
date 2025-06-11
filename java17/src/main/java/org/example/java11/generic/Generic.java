package org.example.java11.generic;

public class Generic {

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T{
        throw (T) e;
    }
}
