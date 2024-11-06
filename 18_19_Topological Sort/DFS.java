import java.util.*;

// Kahn's Algorithm - Only valid for DAG (Directed Acyclic Graph)
// Linear ordering of vertices such that if there is an edge between u and v, so u appears before v in the ordering

public class DFS {
    private static void dfs(int node, int[] vis, Stack<Integer> st, int[][] mat) {
        vis[node] = 1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[node][i] == 1 && vis[i] == 0) {
                dfs(i, vis, st, mat);
            }
        }
        st.push(node);
    }

    public static int[] topoSort(int V, int[][] mat) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, mat);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        int[][] adjMatrix = new int[n][n];

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        int[] ans = topoSort(n, adjMatrix);
        System.out.println("Topological Sort Order:");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        
        sc.close();
    }
}

/*
 * Step 1:
 * Insert elements in the queue with indegree 0
 * 
 * Step 2:
 * Then check the adjacent edges of the front of the queue, pull it out and
 * decrement the current indegree of adjacent element by 1
 * 
 * Step 3:
 * If the indegree of that elememt becomes zero push it into the queue
 * 
 * Step 4:
 * Repeat Step 1 after Step 3
 */