package com.company;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
Name:       Samuel Howell
Date:       12-14-20
Packet:     2017
 */
public class Problem1
{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;
        ArrayList<String> inputList = new ArrayList<>();
        String[] splitVal;
        HashSet<String> differentStates = new HashSet<>();    //  so there are no replicates
        ArrayList<String> typesOfEclipses = new ArrayList<>();
        String highestOccurrence = "";
        int maxCount = 0;


        ArrayList<StateObj> s = new ArrayList<>();
        s.add(new StateObj("AL", 0));
        s.add(new StateObj("AK", 0));
        s.add(new StateObj("AZ", 0));
        s.add(new StateObj("AR", 0));
        s.add(new StateObj("CA", 0));
        s.add(new StateObj("CO", 0));
        s.add(new StateObj("CT", 0));
        s.add(new StateObj("DE", 0));
        s.add(new StateObj("DC", 0));
        s.add(new StateObj("FL", 0));
        s.add(new StateObj("GA", 0));
        s.add(new StateObj("HI", 0));
        s.add(new StateObj("ID", 0));
        s.add(new StateObj("IL", 0));
        s.add(new StateObj("IN", 0));
        s.add(new StateObj("IA", 0));
        s.add(new StateObj("KS", 0));
        s.add(new StateObj("KY", 0));
        s.add(new StateObj("LA", 0));
        s.add(new StateObj("ME", 0));
        s.add(new StateObj("MD", 0));
        s.add(new StateObj("MA", 0));
        s.add(new StateObj("MI", 0));
        s.add(new StateObj("MN", 0));
        s.add(new StateObj("MS", 0));
        s.add(new StateObj("MO", 0));
        s.add(new StateObj("MT", 0));
        s.add(new StateObj("NE", 0));
        s.add(new StateObj("NV", 0));
        s.add(new StateObj("NH", 0));
        s.add(new StateObj("NJ", 0));
        s.add(new StateObj("NM", 0));
        s.add(new StateObj("NY", 0));
        s.add(new StateObj("NC", 0));
        s.add(new StateObj("ND", 0));
        s.add(new StateObj("OH", 0));
        s.add(new StateObj("OK", 0));
        s.add(new StateObj("OR", 0));
        s.add(new StateObj("PA", 0));
        s.add(new StateObj("RI", 0));
        s.add(new StateObj("SC", 0));
        s.add(new StateObj("SD", 0));
        s.add(new StateObj("TN", 0));
        s.add(new StateObj("TX", 0));
        s.add(new StateObj("UT", 0));
        s.add(new StateObj("VT", 0));
        s.add(new StateObj("VA", 0));
        s.add(new StateObj("WA", 0));
        s.add(new StateObj("WV", 0));
        s.add(new StateObj("WI", 0));
        s.add(new StateObj("WY", 0));


        int fCount = 0;
        int pCount = 0;
        int nCount = 0;

        //  get input
        while(true)
        {
            input = sc.nextLine();
            if(input.equals("-1"))
                break;
            inputList.add(input);
        }

        //  parse the string
        for(String val : inputList)
        {
            splitVal = val.split(" ");

            //  add occurrences of each state
            for(int i = 0; i < s.size(); i++)
            {
                if(splitVal[0].equals(s.get(i).getState()))
                {
                    int count = s.get(i).getCount() + 1;
                    s.get(i).setCount(count);
                }
            }

            // find highest occurrence
            for(int i = 0; i < s.size(); i++)
            {
                if(s.get(i).getCount() > maxCount)
                {
                    maxCount = s.get(i).getCount();
                    highestOccurrence = s.get(i).getState();
                }
            }

            //TODO: If two states occupy highestOcccurence, then choose the state that is alphabetically first.

            differentStates.add(splitVal[0]);
            typesOfEclipses.add(splitVal[1]);
        }

        //  check for counts in the typesOfEclipses
        for(int i = 0 ; i < typesOfEclipses.size(); i++)
        {
            if(typesOfEclipses.get(i).equals("F")) fCount++;
            if(typesOfEclipses.get(i).equals("P")) pCount++;
            if(typesOfEclipses.get(i).equals("N")) nCount++;
        }


        //  output
        System.out.println("Different states surveyed = " + differentStates.size());
        System.out.println("Total Full Eclipses reported = " + fCount);
        System.out.println("Total of Partial Eclipses Reported = " + pCount);
        System.out.println("Total No Eclipses Reporte  = " + nCount);
        System.out.println("State with most responses = " + highestOccurrence);


    }
}

class StateObj
{
    private String state;
    private int count;

    public StateObj(String state, int count)
    {
        this.state = state;
        this.count = count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getCount()
    {
        return count;
    }

    public String getState()
    {
        return state;
    }
}