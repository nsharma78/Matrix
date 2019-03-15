/*
	Given a m * n matrix, if an element is 0, set its entire row and column to 0.
	Do it in place.
 */

package main.java;

public class SetZeroes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0};
        int[][] mat = MatrixUtils.create2DMatrix(arr, 4, 4);
        System.out.println("=======Before=======\n");
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("=======After=======\n");
        setZeroes(mat);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
    }

    private static void setZeroes(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        // if the first row has 0
        for(int i = 0; i < col; i++) {
            if (mat[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // if the first col has 0
        for(int i = 0; i < row; i++) {
            if (mat[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        // if find 0 set the corresponding first row and column index to 0
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // if 0 in first row or column corresponding elements set the element to 0
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        //if first row has 0 set first row to 0
        if(firstRowHasZero)
            for(int i = 0; i < col; i++)
                mat[0][i] = 0;

        //if first col has 0 set first row to 0
        if(firstColumnHasZero)
            for(int i = 0; i < row; i++)
                mat[i][0] = 0;

    }
}
