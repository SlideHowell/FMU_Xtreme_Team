import java.util.Scanner;
import java.util.HashSet;
public class Problem8_2018
{
    public static void main(String[] args)
    {
        // Declaring some stuff
        Scanner input = new Scanner(System.in);
        final int MATRIX = Integer.parseInt(input.nextLine());
        boolean[] result = new boolean[MATRIX];

        // Check if a matrix is a Latin Square
        for (int i = 0; i < MATRIX; i++)
        {
            // Declaring some stuff
            final int LENGTH = Integer.parseInt(input.nextLine());
            HashSet<Integer> numberSet = new HashSet<>();
            boolean latinSquare = true;
            int[][] matrix = new int[LENGTH][LENGTH];

            // Parse the input into a 2D array
            for (int j = 0; j < LENGTH; j++)
            {
                String[] inputArray = input.nextLine().split(" ");
                for (int k = 0; k < LENGTH; k++)
                {
                    matrix[j][k] = Integer.parseInt(inputArray[k]);
                }
            }
            // Convert the first row into a set and check if it is unique
            for (int digit : matrix[0])
                numberSet.add(digit);
            if (numberSet.size() != LENGTH)
                latinSquare = false;

            // Check if every other row contains the digits from the first row
            for (int j = 1; j < LENGTH; j++)
            {
                HashSet<Integer> number = new HashSet<>();
                for (int digit : matrix[j])
                    number.add(digit);
                if (!numberSet.equals(number))
                    latinSquare = false;
            }
            // Check if every column contains the digits from the first row
            for (int j = 0; j < LENGTH; j++)
            {
                HashSet<Integer> number = new HashSet<>();
                for (int k = 0; k < LENGTH; k++)
                {
                    number.add(matrix[k][j]);
                }
                if (!numberSet.equals(number))
                    latinSquare = false;
            }
            // Save the result to the boolean array
            result[i] = latinSquare;
        }
        // Prints result
        for (int i = 0; i < MATRIX; i++)
        {
            System.out.printf("Matrix %d: ", i + 1);
            if (result[i])
                System.out.println("is a Latin Square.");
            else
                System.out.println("is not a Latin Square.");
        }
    }
}
