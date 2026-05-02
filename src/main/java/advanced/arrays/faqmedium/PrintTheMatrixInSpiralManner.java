package advanced.arrays.faqmedium;

import java.util.ArrayList;
import java.util.List;

public class PrintTheMatrixInSpiralManner {

    public static void main(String[] args) {
        PrintTheMatrixInSpiralManner printTheMatrixInSpiralManner = new PrintTheMatrixInSpiralManner();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> spiralOrder = printTheMatrixInSpiralManner.spiralOrder(matrix);
        System.out.println(spiralOrder);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;

        while(top <= bottom && left <= right) {
            //Left to right
            for (int i = left; i <= right; ++i) {
                ans.add(matrix[top][i]);
            }
            top++;

            //Top to bottom
            for (int i = top; i <= bottom; ++i) {
                ans.add(matrix[i][right]);
            }
            right--;

            //Right to left
            if (top <= bottom) {
                for(int i = right; i >= left; --i) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
