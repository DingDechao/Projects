package org.example.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchPhoneNumberbyPatternAndMatcherTest {
    public static void main(String[] args) {
        String s = """
                aaa -> 13600000000
                bbb -> 15000000000
                ccc -> 13500000000
                """;
        Pattern pattern = Pattern.compile("((13\\d)|(15\\d))\\d{8}");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
