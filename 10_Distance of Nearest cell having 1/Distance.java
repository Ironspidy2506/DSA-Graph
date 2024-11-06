import java.util.*;

class Pair {
    int row;
    int col;
    int step;

    Pair() {

    }

    Pair(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

public class Distance {
    public static void printGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findDistance(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int ro = p.row;
            int co = p.col;
            int st = p.step;

            result[ro][co] = st;

            for (int i = 0; i < 4; i++) {
                int nerow = ro + derow[i];
                int necol = co + decol[i];
                if (nerow >= 0 && nerow < m && necol >= 0 && necol < n && vis[nerow][necol] == false
                        && mat[nerow][necol] == 0) {
                    q.add(new Pair(nerow, necol, st + 1));
                    vis[nerow][necol] = true;
                }
            }
        }

        return result;
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

        int[][] result = findDistance(mat);
        printGraph(result);

        sc.close();
    }
}
