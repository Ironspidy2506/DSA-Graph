import java.util.*;

public class Enclaves {

    public static void dfs(int r, int c, boolean[][] vis, int[][] mat, int[] derow, int[] decol) {
        int m = vis.length;
        int n = vis[0].length;
        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nerow = r + derow[i];
            int necol = c + decol[i];

            if (nerow >= 0 && nerow < m && necol >= 0 && necol < n && vis[nerow][necol] == false
                    && mat[nerow][necol] == 1) {
                dfs(nerow, necol, vis, mat, derow, decol);
            }
        }
    }

    public static int numberOfEnclave(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };
        int count = 0;
        // First and Last Col
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 1 && vis[i][0] == false) {
                dfs(i, 0, vis, mat, derow, decol);
            }

            if (mat[i][n - 1] == 1 && vis[i][n - 1] == false) {
                dfs(i, n - 1, vis, mat, derow, decol);
            }
        }

        // First and Last Row
        for (int i = 0; i < n; i++) {
            if (mat[0][i] == 1 && vis[0][i] == false) {
                dfs(0, i, vis, mat, derow, decol);
            }

            if (mat[m - 1][i] == 1 && vis[m - 1][i] == false) {
                dfs(m - 1, i, vis, mat, derow, decol);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && mat[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row dimension: ");
        int m = sc.nextInt();
        System.out.print("Enter the col dimension: ");
        int n = sc.nextInt();
        System.out.println("Start entering the matrix value");
        int[][] mat = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(numberOfEnclave(mat));

        sc.close();
    }

}
