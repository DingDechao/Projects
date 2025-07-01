package org.example.web;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest0 {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress0 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress0.isReachable(2_000));
        System.out.println(inetAddress0.getHostAddress());
        System.out.println(inetAddress0.getCanonicalHostName());

        InetAddress inetAddress1 = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println(inetAddress1.isReachable(2_000));
        System.out.println(inetAddress1.getCanonicalHostName());
        System.out.println(inetAddress1.getHostName());

    }
}
