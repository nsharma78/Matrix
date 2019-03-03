package main.java;

public class MatrixUtils {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,10,11,16,20,23,30,34,50};
        int[] binArr = {1,0,1,0,0,1,1,0,1,0,1,0};
        int[][] matrix = create2DMatrix(arr, 3, 4);
        print2DMatrix(matrix, matrix.length, matrix[0].length);
        int[][] binMat = create2DMatrix(binArr, 3, 4);
        print2DBinaryMatrix(binMat, binMat.length, binMat[0].length);
    }

    public static int[][] create2DMatrix(int[] arr, int row, int col) {
        int[][] matrix = new int[row][col];
        int k = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                matrix[i][j] = arr[k++];
        }
        return matrix;
    }

    public static void print2DMatrix(int[][] matrix, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                if(matrix[i][j] < 10)
                    System.out.print(matrix[i][j] + "  ");
                else
                    System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void print2DBinaryMatrix(int[][] matrix, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                if(matrix[i][j] == 1)
                    System.out.print("X" + " ");
                else
                    System.out.print("-" + " ");
            System.out.println();
        }
    }

    public static void printBoolean2DMatrix(boolean[][] matrix, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                System.out.print(matrix[i][j] + "  ");
            System.out.println();
        }
    }
}
