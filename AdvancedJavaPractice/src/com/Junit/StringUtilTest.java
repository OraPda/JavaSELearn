package com.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
//    测试方法：必须是公开public、无参、无返回值的
//    测试方法必须加@Test注解
    @Test
    public void test1() {

        StringUtil.printNumber("123");
        StringUtil.printNumber("123.456");
        StringUtil.printNumber("123.456.789");
        StringUtil.printNumber(null);
    }
    @Test
    public void test2() {

        System.out.println(StringUtil.printMaxIndex("123"));
        System.out.println(StringUtil.printMaxIndex("123.456"));
        System.out.println(StringUtil.printMaxIndex("123.456.789"));

        System.out.println(StringUtil.printMaxIndex(null));

        //做断言测试：测试结果是否与预期结果一致
        Assertions.assertEquals(StringUtil.printMaxIndex("123"), 3, "测试结果不一致");
        Assertions.assertEquals(StringUtil.printMaxIndex("123.456"), 7, "测试结果不一致");
        Assertions.assertEquals(StringUtil.printMaxIndex("123.456.789"), 10, "测试结果不一致");
        Assertions.assertEquals(StringUtil.printMaxIndex(null), -1, "测试结果不一致");
        assert StringUtil.printMaxIndex("123") == 3;
        assert StringUtil.printMaxIndex("123.456") == 7;
        assert StringUtil.printMaxIndex("123.456.789") == 10;
        assert StringUtil.printMaxIndex(null) == -1;
    }
}
