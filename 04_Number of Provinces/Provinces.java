import java.util.*;

class Provinces {
    public static void dfs(List<List<Integer>> adj,boolean[] vis, int node) {
        vis[node] = true;
        
        for (int nodes : adj.get(node)) {
            if (vis[nodes] == false) {
                dfs(adj, vis, nodes);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            System.out.println("Enter the adjacent vertices for the node " + i);
            System.out.println("Enter -1 to stop entering then vertices");
            while (sc.hasNext()) {
                int val = sc.nextInt();
                if (val == -1) {
                    break;
                }
                temp.add(val);
            }
            list.add(temp);
        }

        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                count++;
                dfs(list, vis, i); // We can use BFS either
            }
        }

        System.out.println(count);
        sc.close();
    }
}