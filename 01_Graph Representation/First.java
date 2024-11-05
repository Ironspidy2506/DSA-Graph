import java.util.*;

class First {
    public static void printGraph(List<List<Integer>> adjlist) {
        int idx = 1;
        for (List<Integer> list : adjlist) {
            System.out.println(idx + "->" + list);
            idx++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
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

        printGraph(list);

        sc.close();
    }
}