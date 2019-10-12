package TestingTriangleInequality;

class TriangleInequality {
    static boolean isTriangleExist(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return a < b + c && b < a + c && c < a + b;
    }
}