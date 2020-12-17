package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class problem1
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> namesArr = new ArrayList<>();

        //  get input
        while(true)
        {
            String name = sc.nextLine().toUpperCase();
            if(name.equals("LAST")) break;
            namesArr.add(name);
        }

        //  declare stuff
        ArrayList<Integer> vowelIndexes = new ArrayList<>();
        ArrayList<Character> vowelChars = new ArrayList<>();
        ArrayList<Character> consonantChars = new ArrayList<>();
        ArrayList<String> finalOutput = new ArrayList<>();
        StringBuilder vowels = new StringBuilder();
        StringBuilder remainingConsonants = new StringBuilder();
        StringBuilder newName = new StringBuilder();

        for(String name : namesArr)
        {
            char[] nameArr = name.toCharArray();

            //  identify the positions of the vowels
            for(int i = 0; i < nameArr.length; i++)
            {
                if(isVowel(nameArr[i]))
                {
                    vowelIndexes.add(i);
                    vowels.append(nameArr[i]);
                }
            }

            //  pull out the vowels into a StringBuilder and reverse them, then add them to an arraylist for increased manipulation flexibility
                vowels.reverse();
                char[] reversedVowels = vowels.toString().toCharArray();
                for(char c : reversedVowels) vowelChars.add(c);

            //  put the remaining consonants into a StringBuilder and reverse them, then add them to an arraylist for increased manipulation flexibility
                for(char c : nameArr) if(!isVowel(c)) remainingConsonants.append(c);   //  removes the vowels from the array
                remainingConsonants.reverse();

                char[] reversedConsonants = remainingConsonants.toString().toCharArray();
                for(char c : reversedConsonants) consonantChars.add(c);

            //  add in the reversed vowels in their original positions
                for(int i = 0; i < nameArr.length; i++)
                {
                    //if vowel position, place vowel
                    if(i == vowelIndexes.get(0))
                    {
                        newName.append(vowelChars.get(0));
                        vowelChars.remove(0);
                        vowelIndexes.remove(0);
                    }
                    if(!consonantChars.isEmpty())       //  keeps from throwing index out of bounds error.
                    {
                        newName.append(consonantChars.get(0));
                        consonantChars.remove(0);
                    }
                }

                finalOutput.add(name + ":" + newName);
        }

        //  print final output
        for(String result : finalOutput)
        {
            System.out.println(result);
        }
    }

    public static boolean isVowel(char c)
    {
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }

}
