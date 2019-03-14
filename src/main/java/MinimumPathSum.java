/*
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers
 along its path.
 */

package main.java;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,2,1,5,3};
        int[][] mat = MatrixUtils.create2DMatrix(arr,3,3);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("The minimum path sumn from top left to bottom right is: " + minPathSum(mat) );
    }

    private static int minPathSum(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = mat[0][0];

        //left column
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i - 1][0] + mat[i][0];
        }

        //top row
        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j - 1] + mat[0][j];
        }

        //fill up the dp table
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + mat[i][j];
            }
        }
        System.out.println("DP matrix: ");
        MatrixUtils.print2DMatrix(dp, dp.length, dp[0].length);
        return dp[row - 1][col - 1];
    }

    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

}
