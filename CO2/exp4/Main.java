import java.util.Scanner;

//main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the matrix ( m x n ) ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        // Taking user input for matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        // Displaying the matrix and calculating row sums
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            // Displaying the row sums
            System.out.println(": " + rowSum);
        }

        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += matrix[i][j];

            }
            // Displaying the column sums
            System.out.print(colSum + " ");
        }

        scanner.close();
    }
}
