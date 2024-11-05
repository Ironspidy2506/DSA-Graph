import java.util.*;

class Second {
    public static void printGraph(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of Vertices: ");
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            System.out.println("Enter the adjacency array for the " + i + " node");
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        printGraph(mat);

        sc.close();
    }
}