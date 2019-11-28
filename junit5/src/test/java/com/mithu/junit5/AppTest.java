package com.mithu.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

//    @BeforeAll
//    static void testBeforeAll() {
//        System.out.println("this is before all test cases");
//    }
//
//    @BeforeEach
//    void testBeforeEach(TestInfo testInfo) {
//        System.out.println("this is what we are looking for every test call for method " + testInfo.getDisplayName());
//
//    }

    @Test
    void testAssert() {
        assert ("abcde".contains("abc") == true);
    }


    @RepeatedTest(value = 2)
    void testRepeatedTest(){
        System.out.println("repeating test");
    }

    @Test
    @DisplayName("checking assert Equals")
    void testAssertEquals() {
        assertEquals("abcde".contains("abc"), true);
    }

    @Test
    void testAssertArrayEquals() {

        String str = new String("This is a string to test");
        String[] expectedArray = {"This", "is", "a", "string", "to", "test"};

        assertArrayEquals(expectedArray, str.split(" "));

    }

    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(200), ()->{
            for(int i=0; i<100000; i++){
                System.out.println(i);
            }
        });
    }

    @Test
    @Disabled
    void testIgnoreTest(){
        System.out.println("running disabled test");
    }

    @Test
    void testException() {
        String str = null;
        int actualLength = 2;
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @ParameterizedTest(name = "{0} lenghth is {1}")
    @CsvSource( value = {"hello, 5", "this,4"})
    void testParameterized( String string, int length){
        assertEquals(length, string.length());

    }


//    @AfterEach
//    void testAfterEach(TestInfo testInfo) {
//        System.out.println("this is after every method call " + testInfo.getDisplayName());
//    }
//
//    @AfterAll
//    static void testAfterAll() {
//        System.out.println("do this after all method call");
//    }

}
