import java.util.*;

public class Detect {

    public static boolean dfs(List<List<Integer>> list, int start, boolean[] vis, boolean[] pathvis) {
        vis[start] = true;
        pathvis[start] = true;

        for (int node : list.get(start)) {
            if (vis[node] == false) {
                if (dfs(list, node, vis, pathvis)) {
                    return true;
                }
            } else if (pathvis[node] == true) {
                return true;
            }
        }

        pathvis[start] = false;
        return false;
    }

    public static boolean checkCycle(List<List<Integer>> list) {
        boolean[] vis = new boolean[list.size()];
        boolean[] pathvis = new boolean[list.size()];
        // We'll use two arrays visited and path visited
        // Whenever we come back from a dfs we'll mark path visited as false
        for (int i = 0; i < list.size(); i++) {
            if (vis[i] == false) {
                if (dfs(list, i, vis, pathvis)) {
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

        if (checkCycle(list)) {
            System.out.println("Graph has a Cycle");
        } else {
            System.out.println("Graph does not have a Cycle");
        }

        sc.close();
    }
}
