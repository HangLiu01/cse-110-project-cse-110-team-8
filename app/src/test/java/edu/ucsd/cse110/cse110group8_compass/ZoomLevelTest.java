package edu.ucsd.cse110.cse110group8_compass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZoomLevelTest {


    ZoomLevel z1 = new ZoomLevel(1);
    ZoomLevel z2 = new ZoomLevel(2);
    ZoomLevel z3 = new ZoomLevel(3);
    ZoomLevel z4 = new ZoomLevel(4);
    @Test
    public void test_getRadius1_1() {
        assertEquals( 70, z1.getRadius(0.5));
    }

    @Test
    public void test_getRadius1_2() {
        assertEquals( 170, z1.getRadius(300));
    }

    @Test
    public void test_getRadius1_3() {
        assertEquals( 70, z1.getRadius(0.22));
    }

    @Test
    public void test_getRadius2_1() {
        assertEquals( 20, z2.getRadius(0.1));
    }

    @Test
    public void test_getRadius2_2() {
        assertEquals( 100, z2.getRadius(5));
    }

    @Test
    public void test_getRadius2_3() {
        assertEquals( 170, z2.getRadius(500));
    }

    @Test
    public void test_getRadius3_1() {
        assertEquals( 25, z3.getRadius(0.545));
    }

    @Test
    public void test_getRadius3_2() {
        assertEquals( 65, z3.getRadius(5));
    }

    @Test
    public void test_getRadius3_3() {
        assertEquals( 125, z3.getRadius(15));
    }

    @Test
    public void test_getRadius3_4() {
        assertEquals( 170, z3.getRadius(15000));
    }

    @Test
    public void test_getRadius4_1() {
        assertEquals( 18, z4.getRadius(0.34234));
    }

    @Test
    public void test_getRadius4_2() {
        assertEquals( 50, z4.getRadius(5));
    }

    @Test
    public void test_getRadius4_3() {
        assertEquals( 95, z4.getRadius(10));
    }

    @Test
    public void test_getRadius4_4() {
        assertEquals( 140, z4.getRadius(600));
    }

    @Test
    public void test_getRadius4_5() {
        assertEquals( 140, z4.getRadius(23343));
    }
}
