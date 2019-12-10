package TestingTriangleInequality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleInequalityTest {

    @Test
    void equilateralTriangle() {
        assertTrue(TriangleInequality.isTriangleExist(1, 1, 1));
    }

    @Test
    void isoscelesTriangle() {
        assertTrue(TriangleInequality.isTriangleExist(2, 2, 3));
    }

    @Test
    void rightTriangle() {
        assertTrue(TriangleInequality.isTriangleExist(3, 4, 5));
    }

    @Test
    void versatileTriangle() {
        assertTrue(TriangleInequality.isTriangleExist(1.5, 2, 3));
    }

    @Test
    void oneZeroSide() {
        assertFalse(TriangleInequality.isTriangleExist(0, 1, 2));
    }

    @Test
    void oneNegativeSide() {
        assertFalse(TriangleInequality.isTriangleExist(-1.5, 2, 3));
    }

    @Test
    void sumOfTwoSidesEqualsThird() {
        assertFalse(TriangleInequality.isTriangleExist(1, 1, 2));
    }

    @Test
    void sumOfTwoSidesLessThenThird() {
        assertFalse(TriangleInequality.isTriangleExist(1, 2, 10));
    }

    @Test
    void allSideEqualsPositiveInfinity() {
        assertFalse(TriangleInequality.isTriangleExist(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

    @Test
    void allSideEqualsMaxDoubleValue() {
        assertTrue(TriangleInequality.isTriangleExist(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }
}
