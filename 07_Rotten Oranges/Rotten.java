import java.util.*;

class Pair {
    int a;
    int b;
    int time;

    Pair() {

    }

    public Pair(int a, int b, int time) {
        this.a = a;
        this.b = b;
        this.time = time;
    }
}

public class Rotten {
    public static int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int cntfresh = 0;

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (mat[i][j] == 1) {
                    cntfresh++;
                }
            }
        }

        int time = 0;
        int[] derow = { -1, 0, 1, 0 };
        int[] decol = { 0, 1, 0, -1 };
        int cnt = 0;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int ro = p.a;
            int co = p.b;
            int ti = p.time;
            time = Math.max(time, ti);

            for (int i = 0; i < 4; i++) {
                int nerow = ro + derow[i];
                int necol = co + decol[i];
                if (nerow >= 0 && nerow < m && necol >= 0 && necol < n && mat[nerow][necol] == 1
                        && vis[nerow][necol] == 0) {
                    q.add(new Pair(nerow, necol, ti + 1));
                    vis[nerow][necol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntfresh) {
            return -1;
        }

        return time;
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

        System.out.print("Time required to rot the oranges is: " + orangesRotting(mat));

        sc.close();
    }
}
