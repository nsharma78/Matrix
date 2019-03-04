/*
 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
 */

package main.java;

public class GameOfLife {

    public static void main(String[] args) {
        int[] arr = { 	0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 1, 1, 0, 0, 0, 0, 0,
                        0, 0, 1, 1, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                        0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0  };
        int[][] mat = MatrixUtils.create2DMatrix(arr,10,10);
        MatrixUtils.print2DBinaryMatrix(mat, mat.length, mat[0].length);
        System.out.println("\n===================\nNextGeneration\n===================\n");
        int[][] future = nextGeneration(mat);
        MatrixUtils.print2DBinaryMatrix(future, future.length, future[0].length);
    }

    private static int[][] nextGeneration(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0][0];

        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};

        int[][] future = new int[mat.length][mat[0].length];

        for(int i = 0; i < future.length; i++) {
            for (int j = 0; j < future[i].length; j++) {
                int aliveNeighbors = 0;
                for(int k = 0; k < x.length; k++) {
                    if(isValidLive(mat, i + x[k], j + y[k]))
                        aliveNeighbors++;
                }
                //Any live cell with fewer than two live neighbors dies, as if caused by under-population.
                if(mat[i][j]  == 1 && aliveNeighbors < 2)
                    future[i][j] = 0;
                    //Any live cell with two or three live neighbors lives on to the next generation.
                else if(mat[i][j]  == 1 && ((aliveNeighbors == 2) || (aliveNeighbors == 3)) )
                    future[i][j] = 1;
                    //Any live cell with more than three live neighbors dies, as if by over-population..
                else if(mat[i][j]  == 1 && aliveNeighbors > 3)
                    future[i][j] = 0;
                    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                else if(mat[i][j]  == 0 && aliveNeighbors == 3)
                    future[i][j] = 1;
                else
                    future[i][j] = mat[i][j];
            }
        }
        return future;
    }

    private static boolean isValidLive(int[][] mat, int i, int j) {
        return (i >= 0) && (i < mat.length) &&  (j >= 0) && (j < mat[0].length) && (mat[i][j] == 1);
    }
}
