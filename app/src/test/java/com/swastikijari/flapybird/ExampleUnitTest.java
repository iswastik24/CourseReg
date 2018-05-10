package com.swastikijari.flapybird;

import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        usn();
    }
    public void usn(){
        Pattern p = Pattern.compile("^(1da|1DA){1}[0-9]{2}(CS|cs){1}[0-9]{3}$");//. represents single character
        Matcher m = p.matcher("1da15cs153");
        boolean b = m.matches();
    }
    public void mobnum(){
        Pattern p1 = Pattern.compile("[1-9]{1}[0-9]{9}");
        //. represents single character
        Matcher m1 = p1.matcher("9900990099");
        boolean b1 = m1.matches();
    }
}