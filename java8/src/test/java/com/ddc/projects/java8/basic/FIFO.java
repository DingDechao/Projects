package com.ddc.projects.java8.basic;

import org.junit.Assert;
import org.junit.Test;

public class FIFO {
    private final int capacity = 3;
    private Object[] queue = new Object[capacity];
    private int currentIndex;
    private int count;
    public FIFO(){

    }

    @Test
    public void testFIFO(){
        Object a1 = put((Object)1);
        Object a2 = put((Object)2);
        Object a3 = put((Object)3);
        Object b1 = get();
        Assert.assertEquals(a1,b1);
        Object b2 = get();
        Assert.assertEquals(a2,b2);
        Object b3 = get();
        Assert.assertEquals(a3,b3);

    }

    private Object put(Object a){
        for(int i = 0; i<queue.length; i++){
            if(queue[i]==null){
                queue[i] = a;
              //  count++;
                break;
            }
        }
        return a;
    }

    private Object get(){
        Object objcet = null;
        for(int i = 0; i<queue.length; i++){
            if(queue[i]!=null){
                objcet = queue[i];
                queue[i]=null;
                //  count++;
                break;
            }
        }
        return  objcet;
    }

    public static void main(String[] args){

    }
}
