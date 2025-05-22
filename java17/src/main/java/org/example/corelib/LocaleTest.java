package org.example.corelib;

import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        // 返回Java所支持的全部国家和语言的数组
        Locale[] localeList = Locale.getAvailableLocales();
        for (var i = 0; i < localeList.length; i++) {
            System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry() + " "
                    + localeList[i].getDisplayLanguage() + "=" + localeList[i].getLanguage());
        }

        System.out.println("=====================================================");
        // 取得系统默认的国家/语言环境
        var myLocale = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println(myLocale.getDisplayCountry() + "=" + myLocale.getCountry() + " "
                + myLocale.getDisplayLanguage() + "=" + myLocale.getLanguage());
    }
}
