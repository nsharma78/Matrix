/*
 Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, there is one obstacle in the middle of a 3x3 grid as illustrated below,

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
the total number of unique paths is 2.
 */

package main.java;

public class UniquePathObstacles {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,0,0,0,0};
        int[][] mat = MatrixUtils.create2DMatrix(arr,3,3);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("The number of unique path from top left to bottom right are: " + uniquePaths(mat) );
    }

    private static int uniquePaths(int[][] mat) {
        if(mat == null || mat.length == 0)
            return 0;
        int row = mat.length;
        int col = mat[0].length;

        if(mat[0][0] == 0 && mat[row - 1][col - 1] == 1)
            return 0;

        int[][] dp = new int[row][col];
        dp[0][0] = 1;

        //left column
        for(int i = 1; i < row; i++){
            if(mat[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i - 1][0];
        }

        //top row
        for(int j = 1; j < col; j++){
            if(mat[0][j] == 1)
                dp[0][j] = 0;
            else
                dp[0][j] = dp[0][j - 1];
        }

        //fill up the dp table
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(mat[i][j] == 1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }


}
