/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:
    1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.
    For example, consider the following matrix:
    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    Given target = 3, return true.
 */

package main.java;

public class SearchSortedMatrix {

    public static void main(String[]  args) {
        int[] arr1 = {1,3,5,7,10,11,16,20,23,30,34,50};
        int[][] mat1 = MatrixUtils.create2DMatrix(arr1,3,4);
        MatrixUtils.print2DMatrix(mat1, mat1.length, mat1[0].length);
        int num = 4;

        System.out.println("The number in the given matrix is present: " + searchSortedMatrixOne(mat1, num));

        int[] arr = {1,4,7,11,15,2,5,8,12,19,3,6,9,16,22,10,13,14,17,24,18,21,23,26,30};
        int[][] mat = MatrixUtils.create2DMatrix(arr,5,5);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);

        System.out.println("The number in the given matrix is present: " + searchSortedMatrixTwo(mat, num));
    }

    private static boolean searchSortedMatrixOne(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n -1;

        while(start <= end) {
            int mid = (end + start)/2;
            int midx = mid/n;
            int midy = mid%n;

            if(matrix[midx][midy] == num)
                return true;

            if(matrix[midx][midy] < num) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return false;
    }

    private static boolean searchSortedMatrixTwo(int[][] matrix, int target) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;

        int i=m;
        int j=0;

        while(i>=0 && j<=n){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }

        return false;
    }
}
