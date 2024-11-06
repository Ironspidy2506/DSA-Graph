import java.util.*;

class Pair {
    int row;
    int col;
    int step;

    Pair() {}

    Pair(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

public class Surrounded {
    public static void printGraph(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int r, int c, boolean[][] vis, char[][] mat, int[] derow, int[] decol) {
        int m = vis.length;
        int n = vis[0].length;
        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nerow = r + derow[i];
            int necol = c + decol[i];

            if (nerow >= 0 && nerow < m && necol >= 0 && necol < n && !vis[nerow][necol]
                    && mat[nerow][necol] == 'O') {
                dfs(nerow, necol, vis, mat, derow, decol);
            }
        }
    }

    public static char[][] replaceZeroes(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };

        // First and Last Columns
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, vis, mat, derow, decol);
            }
            if (mat[i][n - 1] == 'O' && !vis[i][n - 1]) {
                dfs(i, n - 1, vis, mat, derow, decol);
            }
        }

        // First and Last Rows
        for (int i = 0; i < n; i++) {
            if (mat[0][i] == 'O' && !vis[0][i]) {
                dfs(0, i, vis, mat, derow, decol);
            }
            if (mat[m - 1][i] == 'O' && !vis[m - 1][i]) {
                dfs(m - 1, i, vis, mat, derow, decol);
            }
        }

        // Replace unvisited 'O's with 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row dimension: ");
        int m = sc.nextInt();
        System.out.print("Enter the col dimension: ");
        int n = sc.nextInt();
        System.out.println("Start entering the matrix value");
        char[][] mat = new char[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Result after replacing surrounded 'O's with 'X':");
        char[][] result = replaceZeroes(mat);
        printGraph(result);

        sc.close();
    }
}
