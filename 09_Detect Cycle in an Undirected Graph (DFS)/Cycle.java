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
    public static boolean checkCycle(List<List<Integer>> adjList, boolean[] vis, int src, int parent) {
        vis[src] = true;

        for (int node : adjList.get(src)) {
            if (vis[node] == false) {
                if (checkCycle(adjList, vis, node, src))
                    return true;
            } else if (parent != node) { // Already visited node and wo parent nai hai
                return true;
            }
        }

        return false;
    }

    public static boolean isCycle(List<List<Integer>> list, int n) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                if (checkCycle(list, vis, i, -1)) {
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
