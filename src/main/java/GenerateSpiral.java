/*
 Given an integer n, generate a square matrix of size n*n filled with elements from 1 to n*n in spiral order. For example, given n = 4,
[
[1,   2,  3, 4],
[12, 13, 14, 5],
[11, 16, 15, 6],
[10,  9,  8, 7]
]
*/

package main.java;

public class GenerateSpiral {

    public static void main(String[] argds) {

        int n = 4;
        int[][] matrix = generateSpiral(n);
        MatrixUtils.print2DMatrix(matrix, matrix.length, matrix[0].length);

    }

    private static int[][] generateSpiral(int n) {
        if (n <= 1)
            return new int[][]{};

        int[][]  mat = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int k = 1;

        while(true) {
            if(left > right)
                break;
            for(int i = left; i <= right; i++ )
                mat[top][i] = k++;
            top++;

            if(top > bottom)
                break;
            for(int i = top; i <= bottom; i++)
                mat[i][right] = k++;
            right--;

            if(left > right)
                break;
            for(int i = right; i >= left; i--)
                mat[bottom][i] = k++;
            bottom--;

            if(top > bottom)
                break;
            for(int i = bottom; i >= top; i--)
                mat[i][left] = k++;
            left++;
        }
        return mat;

    }
}
