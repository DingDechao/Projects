package org.example.java11.thread;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyThread extends Thread {

    private long copylengh;
    private long copynew;
    private RandomAccessFile raffrom;
    private RandomAccessFile rafto;
    private long beginindex;


    public CopyThread(long copylengh, long copynew, RandomAccessFile raffrom,
                      RandomAccessFile rafto, long beginindex) {
        this.copylengh = copylengh;
        this.copynew = copynew;
        this.raffrom = raffrom;
        this.rafto = rafto;
        this.beginindex = beginindex;
    }


    public void run() {
        long time1 = System.currentTimeMillis();
        try {
            byte[] buff = new byte[1024 * 1024 * 10];
            int len = -1;
            raffrom.seek(beginindex);
            rafto.seek(beginindex);

            System.out.println("--" + beginindex);
            System.out.println("++" + copylengh);
            while ((len = raffrom.read(buff)) != -1 && copynew <= copylengh) {
                rafto.write(buff, 0, len);
                System.out.println(this.getName() + "拷贝字节：" + len);
                copynew += len;
            }
            long time2 = System.currentTimeMillis();
            System.out.println(this.getName() + "拷贝结束,拷贝总子节数：" + copynew + "耗时：" + (time2 - time1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

