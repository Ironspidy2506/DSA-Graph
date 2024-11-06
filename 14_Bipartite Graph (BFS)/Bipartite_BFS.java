import java.util.*;

public class Bipartite_BFS {
    public static boolean check(List<List<Integer>> list, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int node : list.get(num)) {
                if (color[node] == -1) {
                    color[node] = color[num] == 1 ? 0 : 1;
                    q.add(node);
                } else if (color[node] == color[num]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean checkBipartite(List<List<Integer>> list) {
        int[] color = new int[list.size()];
        Arrays.fill(color, -1);

        for (int i = 0; i < list.size(); i++) {
            if (color[i] == -1) {
                if (!check(list, i, color)) {
                    return false;
                }
            }
        }

        return true;

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

        if (checkBipartite(list)) {
            System.out.println("Graph is Bipartite Graph");
        } else {
            System.out.println("Graph is not a Bipartite Graph");
        }

        sc.close();
    }
}
