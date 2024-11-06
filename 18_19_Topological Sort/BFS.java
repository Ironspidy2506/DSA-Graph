import java.util.*;

// Kahn's Algorithm - Only valid for DAG (Directed Acyclic Graph)
// Linear ordering of vertices such that if there is an edge between u and v, so u appears before v in the ordering

public class BFS {
    public static int[] topoSort(int[][] mat) {
        int n = mat.length;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        int[] topo = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }

        for (int j = 0; j < indegree.length; j++) {
            if (indegree[j] == 0) {
                q.add(j);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            topo[i++] = temp;

            for (int k = 0; k < n; k++) {
                if (mat[temp][k] == 1) {
                    indegree[k]--;
                    if (indegree[k] == 0) {
                        q.add(k);
                    }
                }
            }
        }

        return topo;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        int[][] adjMat = new int[n][n];

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = sc.nextInt();
            }
        }

        int[] ans = topoSort(adjMat);
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