package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwitchWithJDK17TestTest {

    @Test
    void testSwitchCharTest() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        switchWithJDK17Test.switchCharTest('A');
        switchWithJDK17Test.switchCharTest('B');
        switchWithJDK17Test.switchCharTest('C');
        switchWithJDK17Test.switchCharTest('D');
        switchWithJDK17Test.switchCharTest('F');
        switchWithJDK17Test.switchCharTest('E');
    }

    @Test
    void testSwitchStringTest() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        switchWithJDK17Test.switchStringTest("冬天");
        switchWithJDK17Test.switchStringTest("秋天");
        switchWithJDK17Test.switchStringTest("夏天");
        switchWithJDK17Test.switchStringTest("春天");
        switchWithJDK17Test.switchStringTest("F");
    }

    @Test
    void testSwitchStringWithJDK17Test0() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        switchWithJDK17Test.switchStringWithJDK17Test0("冬天");
        switchWithJDK17Test.switchStringWithJDK17Test0("秋天");
        switchWithJDK17Test.switchStringWithJDK17Test0("夏天");
        switchWithJDK17Test.switchStringWithJDK17Test0("春天");
        switchWithJDK17Test.switchStringWithJDK17Test0("F");
    }

    @Test
    void testSwitchStringWithJDK17Test1() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        switchWithJDK17Test.switchStringWithJDK17Test1("冬天");
        switchWithJDK17Test.switchStringWithJDK17Test1("秋天");
        switchWithJDK17Test.switchStringWithJDK17Test1("夏天");
        switchWithJDK17Test.switchStringWithJDK17Test1("春天");
        switchWithJDK17Test.switchStringWithJDK17Test1("F");
    }

    @Test
    void testSwitchStringWithJDK17Test2() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        var result0 = switchWithJDK17Test.switchStringWithJDK17Test2("冬天");
        Assertions.assertEquals("冬天", result0);
        var result1 = switchWithJDK17Test.switchStringWithJDK17Test2("秋天");
        Assertions.assertEquals("秋天", result1);
        var result2 = switchWithJDK17Test.switchStringWithJDK17Test2("夏天");
        Assertions.assertEquals("春天 或者 夏天", result2);
        var result3 = switchWithJDK17Test.switchStringWithJDK17Test2("春天");
        Assertions.assertEquals("春天 或者 夏天", result3);
        var result4 = switchWithJDK17Test.switchStringWithJDK17Test2("F");
        Assertions.assertEquals("季节输入错误", result4);
    }

    @Test
    void testSwitchStringWithJDK17Test3() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        var result0 = switchWithJDK17Test.switchStringWithJDK17Test3("冬天");
        Assertions.assertEquals("冬天", result0);
        var result1 = switchWithJDK17Test.switchStringWithJDK17Test3("秋天");
        Assertions.assertEquals("秋天", result1);
        var result2 = switchWithJDK17Test.switchStringWithJDK17Test3("夏天");
        Assertions.assertEquals("春天 或者 夏天", result2);
        var result3 = switchWithJDK17Test.switchStringWithJDK17Test3("春天");
        Assertions.assertEquals("春天 或者 夏天", result3);
        var result4 = switchWithJDK17Test.switchStringWithJDK17Test3("F");
        Assertions.assertEquals("季节输入错误", result4);
    }

    @Test
    void testSwitchStringWithJDK17Test4() {
        var switchWithJDK17Test = new SwitchWithJDK17Test();
        var result0 = switchWithJDK17Test.switchStringWithJDK17Test4("冬天");
        Assertions.assertEquals("冬天", result0);
        var result1 = switchWithJDK17Test.switchStringWithJDK17Test4("秋天");
        Assertions.assertEquals("秋天", result1);
        var result2 = switchWithJDK17Test.switchStringWithJDK17Test4("夏天");
        Assertions.assertEquals("春天 或者 夏天", result2);
        var result3 = switchWithJDK17Test.switchStringWithJDK17Test4("春天");
        Assertions.assertEquals("春天 或者 夏天", result3);
        var result4 = switchWithJDK17Test.switchStringWithJDK17Test4("F");
        Assertions.assertEquals("季节输入错误", result4);
    }
}