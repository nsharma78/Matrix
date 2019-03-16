/*
 A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?
 */

package main.java;

public class UniquePaths {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[][] mat = MatrixUtils.create2DMatrix(arr,4,5);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("The number of unique path from top left to bottom right are: " + uniquePaths(mat.length, mat[0].length) );
    }

    private static int uniquePaths(int row, int col) {
        if (row == 0 || col == 0)
            return 0;
        if (row == 1 || col == 1)
            return 1;

        int[][] dp = new int[row][col];

        //left column
        for(int i = 0; i < row; i++){
            dp[i][0] = 1;
        }

        //top row
        for(int j = 0; j < col; j++){
            dp[0][j] = 1;
        }

        //fill up the dp table
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row - 1][col - 1];
    }

}
