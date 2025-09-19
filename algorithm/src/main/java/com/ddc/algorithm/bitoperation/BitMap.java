package com.ddc.algorithm.bitoperation;

public class BitMap {

    private long[] words;
    private int size;

    public BitMap(int size) {
        this.size = size;
        words = new long[(size + 63) >> 6];
    }

    public boolean getBit(int index) {
        if (index < 0 || index > size -1 ) {
            throw new IndexOutOfBoundsException("It's not a valid index");
        }
        int wordIndex = index >> 6;
        return (words[wordIndex] & (1L << index)) !=0;
    }

    public void setBit(int index) {
        if (index < 0 || index > size -1 ) {
            throw new IndexOutOfBoundsException("It's not a valid index");
        }
        int wordIndex = index >> 6;
        words[wordIndex] |= (1L << index);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        bitMap.setBit(99);
        System.out.println(bitMap.getBit(126)); //true
        System.out.println(bitMap.getBit(78)); //false
        System.out.println(bitMap.getBit(5));   //true
        System.out.println(bitMap.getBit(99)); //false
    }
}
