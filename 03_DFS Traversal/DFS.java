import java.util.*;

class DFS {
    public static void dfs(List<List<Integer>> adj, List<Integer> list, boolean[] vis, int node) {
        vis[node] = true;
        list.add(node);

        for (int nodes : adj.get(node)) {
            if (vis[nodes] == false) {
                dfs(adj, list, vis, nodes);
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

        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        dfs(list, res, vis, 0);

        System.out.println(res);
        sc.close();
    }
}