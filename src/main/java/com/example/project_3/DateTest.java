//package com.example.project_3.fitness;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class DateTest {
//    @Test
//    public void test1() {
//        Date date = new Date(11, 32,2006);
//        assertFalse(date.isValid());
//    }
//    @Test
//    public void test2() {
//        Date date = new Date(13, 21,2000);
//        assertTrue(date.dobIsEighteen());
//    }
//    @Test
//    public void test3() {
//        Date date = new Date(2, 12,2024);
//        assertTrue(date.isValid());
//    }
//    @Test
//    public void test4() {
//        Date date = new Date(2, 22,2024);
//        assertTrue(date.isValid());
//    }
//    @Test
//    public void test5() {
//        Date date = new Date(11, 21,2000);
//        assertTrue(date.isValid());
//    }
//    @Test
//    public void test6() {
//        Date date = new Date(3, 5,2012);
//        assertTrue(date.isValid());
//    }
//    @Test
//    public void test7() {
//        Date date = new Date(13, 21,2008);
//        assertFalse(date.dobIsEighteen());
//    }
//}