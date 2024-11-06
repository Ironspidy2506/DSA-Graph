import java.util.*;

// If the total count in the traversal (Total element visted after traversal) is not equal to the number of vertices then the Graph contains a Cycle
public class CycleUsingTopo {
    public static boolean CycleDetection(int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int n : adj.get(node)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    q.add(n);
                }
            }
        }

        if (cnt == v) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                if (val == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        System.out.println(CycleDetection(n, adjList));

        sc.close();
    }
}
