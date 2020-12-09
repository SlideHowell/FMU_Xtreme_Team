package com.company;
import java.util.Scanner;

/*
Name:           Samuel Howell
Date:           12-9-20
Problem:        Problem 1: Password Strength
Packet Year:    2018
 */

public class PswdStrength
{

    public static void main(String[] args) {

        //  Rule 1.The minimum length is 6 and the maximum length is 20
        //  At least one uppercase and lowercase letter is used.
        //  Rule 3. At least one digit is used
        //  Rule 4.At least one printable symbol other than $ is used
        //  Rule 5.There cannot be any blank spaces.

        Scanner sc = new Scanner(System.in);

        int numOfInput = sc.nextInt();
        int count = 0;
        sc.nextLine(); //  clear input

        //put each password into a spot in a pswdArray
        String[] pswdArr = new String[numOfInput];

        do
        {
            pswdArr[count] = sc.nextLine();
            count++;

        } while (count != numOfInput);


        int pswdNum = 1;

        for(String pswd : pswdArr)
        {

            //  make a boolean array to store these values^^^^^
            boolean[] answerArr = new boolean[5];

            //  run the pswd through the tests and store the boolean in the answerArr
            answerArr[0] = min6max20(pswd);
            answerArr[1] = upperAndLower(pswd);
            answerArr[2] = hasDigit(pswd);
            answerArr[3] = hasSpecialChar(pswd);
            answerArr[4] = blankSpaces(pswd);

            //  create a StringBuilder to store the error String
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < answerArr.length; i++)
            {
                if(!answerArr[i]) sb.append(i + 1).append(" ");     //  if the boolean stored in the i position in the answerArr is false, append i + 1 (the rule that was violated) to the StringBuilder.
            }


            if (min6max20(pswd) && upperAndLower(pswd) && hasDigit(pswd) && hasSpecialChar(pswd) && blankSpaces(pswd))      //  if everything is true, print that its valid, else print that its not.
            {
                System.out.println("Password " + pswdNum + " is valid");
            }
            else
            {
                System.out.println("Password " + pswdNum + " is invalid by rule(s) " + sb);
            }

            pswdNum++;
        }

    }

    //  checks to see that password has min of 6 char and max of 20
    private static boolean min6max20(String pswd)
    {
        if(pswd.length() >= 6 && pswd.length() <= 20)
        {
            return true;
        }
        return false;
    }

    //  checks to see that password has at least one uppercase and one lowercase letter
    private static boolean upperAndLower(String pswd)
    {
        char currentChar;
        boolean isCapitalLetter = false;
        boolean isLowerCaseLetter = false;

        for (int i = 0; i < pswd.length(); i++)
        {
            currentChar = pswd.charAt(i);
            if (Character.isUpperCase(currentChar))
            {
                isCapitalLetter = true;
            }
            else if (Character.isLowerCase(currentChar))
            {
                isLowerCaseLetter = true;
            }
        }
        if (isLowerCaseLetter && isCapitalLetter)
        {
            return true;
        }
        return false;
    }

    //  checks to see that password has a digit in it
    private static boolean hasDigit(String pswd)
    {
        boolean isDigit;
        for(int i = 0; i < pswd.length(); i++)
        {
            isDigit = Character.isDigit(pswd.charAt(i));
            if(isDigit) return true;
        }
        return false;
    }

    //  checks to see that password has a special char in it
    private static boolean hasSpecialChar(String pswd)
    {
        String specialChars = "~`!@#%^&*()-_=+\\|[{]};:'\",<.>/?";
        boolean specialCharPresent = false;
        char currentChar;

        for(int i = 0; i < pswd.length(); i++)
        {
            currentChar = pswd.charAt(i);
            if (specialChars.contains(String.valueOf(currentChar))) specialCharPresent = true;
        }

        if(specialCharPresent) return true;

        return false;
    }

    //  checks to see if password contains whitespace
    private static boolean blankSpaces(String pswd)
    {
        char currentChar;
        boolean isWhitespace = false;

        for (int i = 0; i < pswd.length(); i++)
        {
            currentChar = pswd.charAt(i);
            if(Character.isWhitespace(currentChar)) isWhitespace = true;
        }

        if (isWhitespace) return false;

        return true;
    }
}
