package org.example.sealedtest;

public abstract sealed class Apple permits Gala {
    public abstract void taste();
}
