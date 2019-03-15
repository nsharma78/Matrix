/*
 	You are given an n x n 2D matrix representing an image.
	Rotate the image by 90 degrees (clockwise). Try in place.
	Example
	1  2  3  4  5
	16 17 18 19 6
	15 24 25 20 7
	14 23 22 21 8
	13 12 11 10 9
	====================================
	After Rotation
	====================================
	13 14 15 16 1
	12 23 24 17 2
	11 22 25 18 3
	10 21 20 19 4
	9  8  7  6  5
 */

package main.java;

public class RotateClockwise {

    // test harness
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,16,17,18,19,6,15,24,25,20,7,14,23,22,21,8,13,12,11,10,9};
        int[][] mat = MatrixUtils.create2DMatrix(arr,5,5);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("====================================\nAfter Rotation\n====================================");
        rotateClockwise(mat);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
    }

    private static void rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

}
