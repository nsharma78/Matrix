/*
 Find the sum of both diagonals for an n*n matrix
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 1 + 9 + 5 = 15
 3 + 9 + 7 = 19
 */

package main.java;
import java.util.*;

public class DiagonalSum {

    public static void main(String[] args) {
        //int[] arr = {1,2,3,8,9,4,7,6,5};
        int[] arr = {1,3,5,7,10,11,16,20,23,30,34,50,60,70,80,90};
        int[][] mat = MatrixUtils.create2DMatrix(arr, 4, 4);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.print("The sum of diagonals of the given matrix is: " + Arrays.toString(diagonalSum(mat)));
    }

    private static int[] diagonalSum(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[]{};

        int[] result = new int[2];
        for(int i = 0;i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(i == j)
                    result[0] = result[0] + mat[i][j];
                if(mat.length - (i + j) == 1)
                    result[1] = result[1] + mat[i][j];
            }
        }
        return result;
    }
}
