/*
 Determine if a Sudoku is valid. The Sudoku board could be partially filled, where empty cells are filled with 0
Ex
	{
		{5, 3, 0. 0, 7, 0, 0, 0, 0},
	    {6, 0, 0. 1, 9, 5, 0, 0, 0},
	    {0, 9, 8. 0, 0, 0, 0, 6, 0},
	    {8, 0, 0. 0, 6, 0, 0, 0, 3},
	    {4, 0, 0. 8, 0, 3, 0, 0, 1},
	    {7, 0, 0. 0, 2, 0, 0, 0, 6},
	    {0, 6, 0. 0, 0, 0, 2, 8, 0},
	    {0, 0, 0. 4, 1, 9, 0, 0, 5},
	    {0, 0, 0. 0, 8, 0, 0, 7, 9},
    }
 */


package main.java;

public class ValidSudoku {

    public static void main(String[] args) {
        int[] arr = { 	5, 3, 0, 0, 7, 0, 0, 0, 0,
                6, 0, 0, 1, 9, 5, 0, 4, 0,
                0, 9, 8, 0, 0, 0, 0, 6, 0,
                8, 0, 0, 0, 6, 0, 0, 0, 3,
                4, 0, 0, 8, 0, 3, 0, 0, 1,
                7, 0, 0, 0, 2, 0, 0, 0, 6,
                0, 6, 0, 0, 0, 0, 2, 8, 0,
                0, 0, 0, 4, 1, 9, 0, 0, 5,
                0, 0, 0, 0, 8, 0, 0, 7, 9 };
        int[][] mat = MatrixUtils.create2DMatrix(arr,9,9);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("\n\nThe given sudoku is valid: " + isValidSudoku(mat));
    }

    private static boolean isValidSudoku(int[][] mat) {
        if(mat == null || mat.length != 9 || mat[0].length != 9)
            return false;

        // check each column
        for(int i = 0; i < 9; i++) {
            boolean[] arr = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(mat[i][j] != 0) {
                    if(arr[mat[i][j] - 1]) {
                        return false;
                    }
                    arr[mat[i][j] - 1] = true;
                }
            }
        }

        // check each row
        for(int j = 0; j < 9; j++) {
            boolean[] arr = new boolean[9];
            for(int i = 0; i < 9; i++) {
                if(mat[i][j] != 0) {
                    if(arr[mat[i][j] - 1]) {
                        return false;
                    }
                    arr[mat[i][j] - 1] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] arr = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (mat[i][j] != 0) {
                        if (arr[mat[i][j] - 1]) {
                            return false;
                        }
                        arr[mat[i][j] - 1] = true;
                    }
                }
            }
        }

        return true;
    }
}
