package com.stepanek.examplerestservice;

import com.stepanek.examplerestservice.service.DefaultNumericService;
import com.stepanek.examplerestservice.service.DifferentNumericService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Pavel Stepanek
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleRestServiceApplicationTests {


    @Test
    public void shiftTest1() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterShifts = dns.doShifts("43256791");
        System.out.println(String.format("Code after processing shifts: %s", codeAfterShifts));
        Assert.assertEquals("45326791", codeAfterShifts);
    }

    @Test
    public void shiftTest2() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterShifts = dns.doShifts("56737823");
        System.out.println(String.format("Code after processing shifts: %s", codeAfterShifts));
        Assert.assertEquals("56773832", codeAfterShifts);
    }

    @Test
    public void shiftTest3() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterShifts = dns.doShifts("1524361728");
        System.out.println(String.format("Code after processing shifts: %s", codeAfterShifts));
        Assert.assertEquals("5142637182", codeAfterShifts);
    }

    @Test
    public void shiftTest4() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterShifts = dns.doShifts("11111111");
        System.out.println(String.format("Code after processing shifts: %s", codeAfterShifts));
        Assert.assertEquals("11111111", codeAfterShifts);
    }

    @Test
    public void shiftTest5() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterShifts = dns.doShifts("56784321");
        System.out.println(String.format("Code after processing shifts: %s", codeAfterShifts));
        Assert.assertEquals("56784132", codeAfterShifts);
    }

    @Test
    public void multiplicationTest1() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterMp = dns.doMultiplication("43256791");
        System.out.println(String.format("Code after processing multiplication: %s", codeAfterMp));
        Assert.assertEquals("432567181", codeAfterMp);
    }

    @Test
    public void multiplicationTest2() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterMp = dns.doMultiplication("45326791");
        System.out.println(String.format("Code after processing multiplication: %s", codeAfterMp));
        Assert.assertEquals("453267181", codeAfterMp);
    }

    @Test
    public void multiplicationTest3() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterMp = dns.doMultiplication("98989898");
        System.out.println(String.format("Code after processing multiplication: %s", codeAfterMp));
        Assert.assertEquals("1816181618161816", codeAfterMp);
    }

    @Test
    public void multiplicationTest4() {
        DefaultNumericService dns = new DifferentNumericService();
        String codeAfterMp = dns.doMultiplication("43256791");
        System.out.println(String.format("Code after processing multiplication: %s", codeAfterMp));
        Assert.assertEquals("432567181", codeAfterMp);
    }

    @Test
    public void multiplicationTest5() {
        DefaultNumericService dns = new DifferentNumericService();
        String codeAfterMp = dns.doMultiplication("98989898");
        System.out.println(String.format("Code after processing multiplication: %s", codeAfterMp));
        Assert.assertEquals("1816181618161816", codeAfterMp);
    }

    @Test
    public void filterTest1() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterFilter = dns.doFilter("453267181");
        System.out.println(String.format("Code after processing filter: %s", codeAfterFilter));
        Assert.assertEquals("45326181", codeAfterFilter);
    }

    @Test
    public void filterTest2() {
        DefaultNumericService dns = new DefaultNumericService();
        String codeAfterFilter = dns.doFilter("7777777");
        System.out.println(String.format("Code after processing filter: %s", codeAfterFilter));
        Assert.assertEquals("", codeAfterFilter);
    }

    @Test
    public void filterTest3() {
        DefaultNumericService dns = new DifferentNumericService();
        String codeAfterFilter = dns.doFilter("453267181");
        System.out.println(String.format("Code after processing filter: %s", codeAfterFilter));
        Assert.assertEquals("45326181", codeAfterFilter);
    }

    @Test
    public void filterTest4() {
        String input = "4532671817";
        String output = input.replace("7", "");
        System.out.println(String.format("Code after processing filter: %s", output));
        Assert.assertEquals("45326181", output);
    }

    @Test
    public void evenDigitCountTest() {
        DefaultNumericService dns = new DefaultNumericService();
        int count = dns.getEvenDigitCount("45326181");
        System.out.println(String.format("Even digit count: %s", count));
        Assert.assertEquals(4, count);
    }

    @Test
    public void divisonTest() {
        DefaultNumericService dns = new DefaultNumericService();
        String result = dns.doDivision("45326181", 4);
        System.out.println(String.format("Divison result: %s", result));
        Assert.assertEquals("11331545", result);
    }

    @Test
    public void algorithmTest() {
        DefaultNumericService dns = new DefaultNumericService();
        String result = dns.transformValue("43256791");
        System.out.println(String.format("Result: %s", result));
        Assert.assertEquals("11331545", result);
    }

    @Test
    public void algorithmTest2() {
        DefaultNumericService dns = new DefaultNumericService();
        String result = dns.transformValue("0123");
        System.out.println(String.format("Result: %s", result));
        Assert.assertEquals("1506", result);
    }

    @Test
    public void algorithmTest3() {
        //zero division test
        DefaultNumericService dns = new DefaultNumericService();
        String result = dns.transformValue("135");
        System.out.println(String.format("Result: %s", result));
        Assert.assertEquals("513", result);
    }

}
