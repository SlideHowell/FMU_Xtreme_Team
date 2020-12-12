import java.util.Scanner;
public class Problem4
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int POTATO = Integer.parseInt(input.nextLine());
        // Jagged array to store the slice volume
        double[][] result = new double[POTATO][];

        // Calculate the slices volume for each potato
        for (int i = 0; i < POTATO; i++)
        {
            // Gather the parameter for calculating slice volume
            String[] userInput = input.nextLine().split(" ");
            final double LENGTH = Double.parseDouble(userInput[0]) / 2;
            final double WIDTH = Double.parseDouble(userInput[1]) / 2;
            final int SLICE = Integer.parseInt(userInput[2]);
            final double THICKNESS = (2 * LENGTH) / SLICE;
            result[i] = new double[SLICE];

            // Calculate the volume of each slice
            for (int j = 0; j < SLICE; j++)
            {
                // Variable "a" is the lower limit and "b" is the upper limit of integration
                // The limit of integration moves accordingly to match the slices of potatoes
                double a = -LENGTH + (THICKNESS * j);
                double b = a + THICKNESS;

                double lowerLimit = -(Math.pow(a, 3) * Math.pow(WIDTH, 2)) / (3 * Math.pow(LENGTH, 2)) + (a * Math.pow(WIDTH, 2));

                double upperLimit = -(Math.pow(b, 3) * Math.pow(WIDTH, 2)) / (3 * Math.pow(LENGTH, 2)) + (b * Math.pow(WIDTH, 2));

                // The volume of the slice, rounded to three decimal places
                double roundedResult = (double) Math.round(((upperLimit - lowerLimit) * Math.PI) * 1000) / 1000;
                result[i][j] = roundedResult;
            }
        }
        // Print the result
        for (int i = 0; i < result.length; i++)
        {
            System.out.println("Potato " + (i + 1));
            for (int j = 0; j < result[i].length; j++)
            {
                System.out.printf("  Slice %d = %.3f\n", j + 1, result[i][j]);
            }
        }
    }
}
