package advanced.arrays.faqmedium;

public class PascalTriangle1 {

    public static void main(String[] args) {
        PascalTriangle1 pascalTriangle1 = new PascalTriangle1();
        System.out.println(pascalTriangle1.pascalTriangleI(5, 2));
    }

    public int pascalTriangleI(int r, int c) {
        return nCr(r-1, c-1);
    }

    private static int nCr(int n, int r) {
        // Choose the smaller value for lesser iterations
        if (r > n - r) {
            r = n - r;
        }

        // base case
        if (r == 1) {
            return n;
        }

        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }
}
