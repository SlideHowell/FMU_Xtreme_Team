package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class problem1
{

    public static void main(String[] args) {

        //use char array for answer key

        //to get high and median. take final grade from each attempt and place it in a float array.

        //  for most correctly and most incorrectly look at the columns of the 2d array to see which has the most true and which has the most false

        //turn each attempt into a boolean array

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int numOfTests = sc.nextInt();
        int numOfAnswers = 25;
        char[] answerKey = input.toCharArray();
        boolean[][] answerMatrix = new boolean[numOfTests][numOfAnswers];

        sc.nextLine();  //  clear scanner

            for(int i = 0; i < numOfTests; i++) //  each row is a new test
            {
                char[] test = sc.nextLine().toCharArray();

                for(int j = 0; j < numOfAnswers; j++) //columns
                {
                    if(test[j] == answerKey[j])
                        answerMatrix[i][j] = true;
                    else
                        answerMatrix[i][j] = false;
                }
            }

         // calculate the grades in the answerMatrix
        double[] finalGrades = new double[numOfTests];

        for(int i = 0 ; i < numOfTests; i++)
        {
            double correct = 0;
            for(int j = 0; j < numOfAnswers; j++)
            {
                if(answerMatrix[i][j]) correct++;
            }
            double finalGrade = correct / numOfAnswers * 100;
            finalGrades[i] = finalGrade;
        }

        for(int i = 0; i < numOfTests; i++)
        {
            System.out.print(finalGrades[i] + ", ");
        }

        //  order the grades
        Arrays.sort(finalGrades);

        //  find highest grade
        double highestGrade = finalGrades[finalGrades.length-1];

        //TODO:Fix this section below
//        //  find median
//        double medianGrade;
//        if(finalGrades.length % 2 != 0) // if odd
//        {
//             medianGrade = finalGrades[finalGrades.length / 2];  //  this is fine as is.
//        }
//        else   // if even
//        {
//             medianGrade =
//        }
        // remember truncation
        //  for even it will be averaged with the -1 (the one to the left
        //  examine the columns to see which one had the most true

        int[] answeredCorrectly = new int[numOfAnswers];
        for(int i = 0; i < numOfAnswers; i++) //  columns
        {
            int correct = 0;
            for(int j = 0; j  < numOfTests; j++)  // rows
            {
                if(answerMatrix[i][j]) correct++;
            }
            answeredCorrectly[i] = correct;
        }

        //  find highest value in the answeredCorrectly array and its index
        int highestCorrectIndex = 0;
        int highestCorrect = 0;

        int lowestCorrectIndex = 0;
        int lowestCorrect = 0;

        for(int i = 0; i < answeredCorrectly.length; i++)
        {
            if(answeredCorrectly[i] > highestCorrect)
            {
                highestCorrect = answeredCorrectly[i];
                highestCorrectIndex = i;
            } else if (answeredCorrectly[i] < lowestCorrect)
            {
                lowestCorrect = answeredCorrectly[i];
                lowestCorrectIndex = i;
            }
        }

        System.out.println("answered incorrectly the most " + (lowestCorrectIndex + 1) );
        System.out.println("answered ");
    }
}
