import java.util.Scanner;
public class Problem2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int MATRIX = Integer.parseInt(input.nextLine());
        final int ROW = 3;
        final int COLUMN = 4;
        final int ELEMENT = ROW * COLUMN;
        String[][][] result = new String[MATRIX][3][4];

        for (int i = 0; i < MATRIX; i++)
        {
            int[][] initialMatrix = new int[3][4];

            // Parse input into 2D array
            for (int j = 0; j < ROW; j++)
            {
                String[] row = input.nextLine().split(" ");
                for (int k = 0; k < COLUMN; k++)
                {
                    initialMatrix[j][k] = Integer.parseInt(row[k]);
                }
            }
            // Find the minimum and maximum value of the array
            int minimum = 100;
            int maximum = 1;
            int[] minIndex = new int[2];
            for (int j = 0; j < ROW; j++)
            {
                for (int k = 0; k < COLUMN; k++)
                {
                    int number = initialMatrix[j][k];
                    if (number < minimum)
                    {
                        minimum = number;
                        minIndex = new int[]{j, k};
                    }
                    if (number > maximum)
                    {
                        maximum = number;
                    }
                }
            }
            //
            int target = minimum;
            int[] previousIndex = minIndex;
            for (int j = 0; j < ELEMENT; j++)
            {
                ++target;
                for (int k = 0; k < ROW; k++)
                {
                    for (int l = 0; l < COLUMN; l++)
                    {
                        int number = initialMatrix[k][l];
                        if (number == target)
                        {
                            result[i][previousIndex[0]][previousIndex[1]] = pair(k, l);
                            previousIndex = new int[]{k, l};
                        }
                        if (number == maximum)
                            result[i][k][l] = "null";
                    }
                }
            }
        }
        // Print Result
        for (int i = 0; i < MATRIX; i++)
        {
            System.out.println("Successor Matrix " + (i + 1) + ":");
            for (int j = 0; j < ROW; j++)
            {
                for (int k = 0; k < COLUMN; k++)
                {
                    System.out.print(result[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    static String pair(int x, int y)
    {
        return "(" + x + "," + y + ")";
    }
}