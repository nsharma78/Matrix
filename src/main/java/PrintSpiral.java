/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	For example, given the following matrix:

	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	You should return [1,2,3,4,5,6,7,8,9].
 */


package main.java;
import java.util.*;

public class PrintSpiral {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,16,17,18,19,6,15,24,25,20,7,14,23,22,21,8,13,12,11,10,9};

        int[][] mat = MatrixUtils.create2DMatrix(arr,5,5);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);

        System.out.println(printSpiral(mat).toString());
    }

    private static List<Integer> printSpiral(int[][] matrix) {

        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while(true) {
            if(left > right)
                break;
            for(int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;

            if(top > bottom)
                break;
            for(int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if(left > right)
                break;
            for(int i = right; i >= left; i--)
                result.add(matrix[bottom][i]);
            bottom--;

            if(top > bottom)
                break;
            for(int i = bottom; i >= top; i--)
                result.add(matrix[i][left]);
            left++;

        }
        return result;
    }
}
