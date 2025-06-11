package org.example.java11;

public enum EnumTest {
    MALE,
    FEMALE;

    EnumTest() {
    }

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        System.out.println(MALE.flag);
    }
}
