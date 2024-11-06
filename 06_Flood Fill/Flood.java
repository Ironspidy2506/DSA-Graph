import java.util.*;

class Pair {
    int a;
    int b;

    Pair() {

    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Flood {
    public static void printGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floodFill(int[][] mat, int srow, int scol, int newcolor) {
        int n = mat.length;
        boolean[][] vis = new boolean[n][n];
        int originalCol = mat[srow][scol];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(srow, scol));
        vis[srow][scol] = true;
        mat[srow][scol] = newcolor;

        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int ro = p.a;
            int co = p.b;

            for (int i = 0; i < 4; i++) {
                int nerow = ro + derow[i];
                int necol = co + decol[i];
                if (nerow >= 0 && nerow < n && necol >= 0 && necol < n && vis[nerow][necol] == false
                        && mat[nerow][necol] == originalCol) {
                    mat[nerow][necol] = newcolor;
                    vis[nerow][necol] = true;
                    q.add(new Pair(nerow, necol));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Matrix: ");
        int n = sc.nextInt();
        System.out.println("Start entering the matrix value");
        int[][] mat = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the start row: ");
        int srow = sc.nextInt();
        System.out.print("Enter the start col: ");
        int scol = sc.nextInt();

        System.out.print("Enter the new color: ");
        int newcolor = sc.nextInt();

        floodFill(mat, srow, scol, newcolor);
        System.out.println("Here's the new matrix with new color flooded");
        printGraph(mat);

        sc.close();
    }
}
