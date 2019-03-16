/*
 Shift a matrix by 1 element in spiral order
  [ 1, 2, 3, 4],
  [ 12, 13, 14, 5],
  [ 11, 16, 15, 6],
  [ 10, 9, 8, 7]

  should become

  [ 16, 1, 2, 3],
  [ 11, 12, 13, 4],
  [ 10, 15, 14, 5],
  [ 9, 8, 7, 6]

 */

package main.java;

public class ShiftSpiral {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,12,13,14,5,11,16,15,6,10,9,8,7};
        int[][] mat = MatrixUtils.create2DMatrix(arr,4,4);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        shiftSpiral(mat);
        System.out.println("The matrix after shift by 1 element in spiral order is\n");
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
    }

    private static void shiftSpiral(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int prev = matrix[0][0];

        while(true){
            if(left > right)
                break;

            for(int i = left; i <= right; ++i) {
                int temp = prev;
                prev = matrix[top][i];
                matrix[top][i] = temp;
            }
            top++;

            if(top > bottom)
                break;

            for(int i = top; i <= bottom; ++i) {
                int temp = prev;
                prev = matrix[i][right];
                matrix[i][right] = temp;
            }
            right--;

            if(left > right)
                break;

            for(int i = right; i >= left; i--){
                int temp = prev;
                prev = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            bottom--;

            if(top > bottom)
                break;

            for(int i = bottom; i >= top; i--) {
                int temp = prev;
                prev = matrix[i][left];
                matrix[i][left] = temp;
            }
            left++;

        }
        matrix[0][0] = prev;
    }
}
