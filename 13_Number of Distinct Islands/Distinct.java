import java.util.*;

public class Distinct {
    public static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public static void dfs(int row, int col, List<String> list, int[][] mat, boolean[][] vis, int row0, int col0) {
        vis[row][col] = true;
        list.add(toString(row - row0, col - col0));

        int m = mat.length;
        int n = mat[0].length;
        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nerow = row + derow[i];
            int necol = col + decol[i];
            if (nerow >= 0 && nerow < m && necol >= 0 && necol < n && vis[nerow][necol] == false
                    && mat[nerow][necol] == 1) {
                dfs(nerow, necol, list, mat, vis, row0, col0);
            }
        }
    }

    public static int numberOfDistinctIslands(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && mat[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, list, mat, vis, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
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

        System.out.println(numberOfDistinctIslands(mat));

        sc.close();
    }
}