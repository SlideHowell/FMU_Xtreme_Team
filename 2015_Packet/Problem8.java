// Problem 8: Diverse Matrix?

import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = Integer.parseInt(scanner.nextLine());
        int[][][] matrices = new int[testCaseCount][][];
        for (int testCase = 0; testCase < testCaseCount; ++testCase)
            matrices[testCase] = readMatrix(scanner);
        
        for (int[][] matrix : matrices)
            System.out.println(isDiverse(matrix) ? "yes" : "no");
    }

    private static boolean isDiverse(int[][] matrix) {
        long[] sums = new long[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            sums[i] = rowSum(matrix[i]);

            for (int j = 0; j < i; ++j)
                if (sums[i] == sums[j])
                    return false;
        }

        return true;
    }

    private static long rowSum(int[] row) {
        long acc = 0;
        for (int i : row)
            acc += i;
        return acc;
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] matrix = new int[rows][cols];
        
        for (int row = 0; row < rows; ++row) {
            String[] elements = scanner.nextLine().split(" ");
            assert elements.length == cols;

            for (int col = 0; col < cols; ++col) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }
        
        return matrix;
    }
}
