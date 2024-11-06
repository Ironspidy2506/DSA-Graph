import java.util.*;

class Pair {
    int curr;
    int prev;

    Pair() {

    }

    Pair(int curr, int prev) {
        this.curr = curr;
        this.prev = prev;
    }
}

public class Cycle {
    public static boolean checkCycle(List<List<Integer>> adjList, boolean[] vis, int src) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int currnode = p.curr;
            int prevnode = p.prev;

            for (int adjnodes : adjList.get(currnode)) {
                if (vis[adjnodes] == false) {
                    vis[adjnodes] = true;
                    q.add(new Pair(adjnodes, currnode));
                } else if (prevnode != adjnodes) { // Already visited node and wo parent nai hai
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(List<List<Integer>> list, int n) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (checkCycle(list, vis, i)) {
                    return true;
                }
            }
        }
        return false;
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

        if (isCycle(list, n)) {
            System.out.println("The graph contains a cycle");
        } else {
            System.out.println("The graph does not contain any cycle");
        }

        sc.close();
    }
}
