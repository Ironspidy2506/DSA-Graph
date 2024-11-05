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

class Island {
    public static void bfs(int row, int col, boolean[][] vis, int[][] grid) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int ro = p.a;
            int co = p.b;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nerow = ro + i;
                    int necol = co + j;
                    if (nerow >= 0 && nerow < n && necol >= 0 && necol < n && vis[nerow][necol] == false
                            && grid[nerow][necol] == 1) {
                        vis[nerow][necol] = true;
                        q.add(new Pair(nerow, necol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && mat[i][j] == 1) {
                    count++;
                    bfs(i, j, vis, mat);
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}