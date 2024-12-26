package com.ddc.projects.java11.basic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NBServer {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            //建立一个channel，并绑定.
            ServerSocketChannel ssc = ServerSocketChannel.open();
            InetAddress addr = InetAddress.getLocalHost();
            InetSocketAddress isa = new InetSocketAddress(addr, 8090);
            ssc.socket().bind(isa);
            //设置模式，为非阻塞模式
            ssc.configureBlocking(false);
            //开始注册服务
            SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int singkey = selector.select();
                if (singkey > 0) {
                    Set selectionkeys = selector.selectedKeys();
                    Iterator i = selectionkeys.iterator();
                    while (i.hasNext()) {
                        SelectionKey key = (SelectionKey) i.next();
                        System.out.println("+++++++++++++");
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                        System.out.println("-------------");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

