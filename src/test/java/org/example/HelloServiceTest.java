package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloServiceTest {
    private HelloService SUT = new HelloService();
    @Test
    public void test_null_prepareGreeting_returnsGreetingWithFallback(){
        //given, when
        var result = SUT.prepareGreeting(null);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }
    @Test
    public void test_null_prepareGreeting_returnsGreetingWithName(){
        //given
        var name = "test";

        // when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);
    }
}
