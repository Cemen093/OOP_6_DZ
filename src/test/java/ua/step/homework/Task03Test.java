package ua.step.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.step.homework.Task03;

public class Task03Test {

    @Test
    void test1(){
        String expeption = "DDAAAADD";
        String actual = Task03.makePalindrome("ADDDDAAAAFFDSD");
        Assertions.assertEquals(expeption,actual);
    }

    @Test
    void test2(){
        String expeption = "АББ ББА";
        String actual = Task03.makePalindrome("АББ ББАAFDSF");
        Assertions.assertEquals(expeption,actual);
    }

    @Test
    void testIsPalindrome() {
        String expeption = "12421";
        String actual = Task03.makePalindrome("1235421");
        Assertions.assertEquals(expeption,actual);
    }

    @Test
    void testPalindromeLetters() {
        String expeption = "hellosolleh";
        String actual = Task03.makePalindrome("henllovsollmeh");
        Assertions.assertEquals(expeption,actual);
    }
}
