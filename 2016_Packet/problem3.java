package com.company;

import java.util.Scanner;

public class problem3
{

    public static void main(String[] args)
    {
	    Scanner scanner = new Scanner(System.in);
	    int numOfCases= scanner.nextInt();
	    int count = 0;
	    int[] answers = new int[numOfCases];
        scanner.nextLine(); // clear scanner

	     while(count != numOfCases)
         {
             String[] c = scanner.nextLine().split(" ");
             double result = Double.parseDouble(c[0]) / Double.parseDouble(c[1]);
             answers[count] = (int)(Math.ceil(result));     //  always round up the percentage, then convert to int
             count++;
         }

	     for(int i = 0 ; i < answers.length; i++)
         {
             System.out.println(answers[i]);
         }
    }
}
