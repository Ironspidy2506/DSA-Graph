import java.util.*;

class BFS {
    public static List<Integer> bfs(List<List<Integer>> list, int V) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int nodes : list.get(node)) {
                if (vis[nodes] == false) {
                    vis[nodes] = true;
                    q.add(nodes);
                }
            }
        }

        return result;
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

        List<Integer> res = bfs(list, n);
        System.out.println(res);
        sc.close();
    }
}