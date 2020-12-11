// This is a solution to Problem 4, Pumpkinfest

import java.util.Scanner;

public class Problem4 {
    private final boolean[][] visitedSquares;
    private final Square[][] garden;
    private final int rows;
    private final int cols;

    enum Square {
        Squash, Pumpkin,
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int gardenCount = Integer.parseInt(scanner.nextLine().trim());
        for (int gardenIndex = 0; gardenIndex < gardenCount; ++gardenIndex) {
            final String[] dimensions = scanner.nextLine().split(" ");
            final int rows = Integer.parseInt(dimensions[0]);
            final int cols = Integer.parseInt(dimensions[1]);
            final Square[][] squares = takeInput(scanner, rows, cols);

            System.out.print("Garden #" + (gardenIndex + 1) + ": largest pumpkin patch size is ");
            System.out.println(new PumpkinPatches(squares).findLargestPumpkinPatch());
        }
    }

    private static Square[][] takeInput(Scanner scanner, final int rows, final int cols) {
        Square[][] squares = new Square[cols][rows];

        for (int row = 0; row < rows; ++row) {
            final String line = scanner.nextLine();

            for (int col = 0; col < cols; ++col) {
                final char ch = line.charAt(col);

                squares[row][col] = ch == 'p' ? Square.Pumpkin : Square.Squash;
            }
        }

        return squares;
    }

    public Problem4(Square[][] garden) {
        this.garden = garden;
        this.rows = garden.length;
        this.cols = garden[0].length;
        this.visitedSquares = new boolean[cols][rows];
    }

    public int findLargestPumpkinPatch() {
        int largestPumpkinPatch = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (!visitedSquares[row][col]) {
                    final int patchSize = visitSquare(row, col);

                    if (patchSize > largestPumpkinPatch)
                        largestPumpkinPatch = patchSize;
                }
            }
        }

        return largestPumpkinPatch;
    }

    private int visitSquare(final int row, final int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visitedSquares[row][col]) {
            visitedSquares[row][col] = true;

            if (garden[row][col] == Square.Pumpkin) {
                return 1
                    + visitSquare(row + 1, col)
                    + visitSquare(row - 1, col)
                    + visitSquare(row, col + 1)
                    + visitSquare(row, col - 1);
            }
        }

        return 0;
    }
}