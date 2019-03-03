/*
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.
Example 1:
11110
11010
11000
00000
Answer: 1

Example 2:
11000
11000
00100
00011
Answer: 3
 */

package main.java;
import java.util.*;

public class CountIslands {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,0,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0};
        //int[] arr = {1,1,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,1,1};
        int[][] mat = MatrixUtils.create2DMatrix(arr,4,5);
        MatrixUtils.print2DMatrix(mat, mat.length, mat[0].length);
        System.out.println("The number of islands in the given matrix is: " + countIslands(mat) );
    }

    static class CoOrds {
        int x, y;
        public CoOrds(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int countIslands(int[][] mat) {
        if (mat == null || mat.length == 0)
            return 0;

        boolean[][] visited = new boolean[mat.length][mat[0].length];
        MatrixUtils.printBoolean2DMatrix(visited, visited.length, visited[0].length);

        int count = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0 && visited[i][j] == false) {
                    bfs(mat, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] mat, boolean[][] visited, int i, int j) {
        int[] row = {0, 0, -1, 1};
        int[] col = {-1, 1, 0, 0};

        Queue<CoOrds> queue = new LinkedList<>();
        queue.add(new CoOrds(i, j));

        visited[i][j] = true;
        CoOrds coOrds = null;

        while(!queue.isEmpty()) {
            coOrds = queue.remove();
            for(int k = 0; k < row.length; k++) {
                if(isSafe(mat, coOrds.x + row[k], coOrds.y + col[k], visited )) {
                    visited[coOrds.x + row[k]][coOrds.y + col[k]] = true;
                    queue.add(new CoOrds(coOrds.x + row[k], coOrds.y + col[k]));
                }
            }

        }

    }

    private static boolean isSafe(int[][] mat, int i, int j, boolean[][] visited) {
        return (i >= 0) && (i < mat.length) && (j >= 0) && (j < mat[0].length) && (mat[i][j] == 1 && !visited[i][j]);
    }
}
