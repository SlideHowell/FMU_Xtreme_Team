package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class tournamentSeeds
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int numOfCases = sc.nextInt();
        int count = 0;

        ArrayList<tournamentSet> sets = new ArrayList<>();
        while(count != numOfCases)
        {
            int numOfPlayers = sc.nextInt();
            int player1 = sc.nextInt();
            int player2 = sc.nextInt();
            int player3 = sc.nextInt();
            tournamentSet set = new tournamentSet(numOfPlayers, player1, player2, player3);
            sets.add(set);
            count++;
        }

        int player1Opponent = 0;
        int player2Opponent = 0;
        int player3Opponent = 0;
        for(tournamentSet set : sets)
        {
            // if numOfPLayers is a power of 2
            if(isPowerOfTwo(set.getNumOfPlayers()))
            {
                // do what you'd do with power of 2
                /*
                   If n is exactly a power of 2, then it is easy to calculate the seed of a given player’s opponent.
                   For any two players who play against each other in their first round, the sum of their seeds is invariant.
                   The value of this invariant is equal to the sum of the highest and lowest seeds.
                   Since n is a power of 2, the highest seeded player is number 1, and the lowest seeded player is
                   number n.
                   Thus, the invariant equals n+ 1.  So, if your seed is s, then the seed of your opponent is (n+ 1) –s.
                   For example, in atournament of 16 players, the opponent of the #2 seed is (16 + 1) –2 = 15, in other words the #15 seed.
                 */
                player1Opponent = (set.getNumOfPlayers() + 1) - set.getPlayer1();
                player2Opponent = (set.getNumOfPlayers() + 1) - set.getPlayer2();
                player3Opponent = (set.getNumOfPlayers() + 1) - set.getPlayer3();

                System.out.println("Seed " + set.getPlayer1() + " plays seed " + player1Opponent + ".");
                System.out.println("Seed " + set.getPlayer1() + " plays seed " + player2Opponent + ".");
                System.out.println("Seed " + set.getPlayer1() + " plays seed " + player3Opponent + ".");

            }
            else
            {
                //  do what you'd do otherwise
                /*
                However, what happens if nis not a power of 2?
                In this case, the top players get “byes” which means they do not play in the first round.
                They automatically qualify for the second round of the tournament.
                The players who do not get byes must play in the first round.
                The number of players who must play in the first round is 2^k, where k is an integer, and 2^k is the
                largest power of 2 less than n.
                Thus, the top (n–2^k) players get byes in the first round.  For the other 2^k players, we can calculate
                 seeds in a straightforward way.
                Again, for any two players in a matchup, the sum of their seeds is an invariant.
                And once again, this invariant is the sum of the highest and lowest seeds of the players who must play in the first round.
                 */

                //  find largest power of 2 less than n (p)
                int n = set.getNumOfPlayers();
                int p = set.getNumOfPlayers();
                while(!isPowerOfTwo(p))
                {
                    p--;
                }
                int newPool = p;

                //find k
                int k = 0;
                while(p != 1)
                {
                    p = p/2;
                    k++;
                }

                //  find which players get byes
                double byePlayers = n - Math.pow(2, k);
                if(set.getPlayer1() < byePlayers)
                {
                    System.out.println("Seed " + set.getPlayer1() + " gets a bye");
                }
                else
                {
                    // FIXME: we have to remove the top players, not the players off the back
                    int seed = (newPool + 1) - set.getPlayer1();
                    System.out.println("Seed " + set.getPlayer1() + " plays seed " + seed + ".");
                }

                if(set.getPlayer2() < byePlayers)
                {
                    System.out.println("Seed " + set.getPlayer2() + " gets a bye");
                }
                else
                {
                    int seed = (newPool + 1) - set.getPlayer2();
                    System.out.println("Seed " + set.getPlayer2() + " plays seed " + seed + ".");
                }

                if(set.getPlayer3() < byePlayers)
                {
                    System.out.println("Seed " + set.getPlayer3() + " gets a bye");
                }
                else
                {
                    int seed = (newPool + 1) - set.getPlayer3();
                    System.out.println("Seed " + set.getPlayer3() + " plays seed " + seed + ".");
                }

            }

        }


    }

    //method to find if num is power of 2
    public static boolean isPowerOfTwo(int n)
    {
        if(n == 0) return false;
        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

static class tournamentSet
{
   private int numOfPlayers;
   private int player1;
   private int player2;
   private int player3;

   public tournamentSet(int numOfPlayers, int player1, int player2, int player3)
   {
       this.numOfPlayers = numOfPlayers;
       this.player1 = player1;
       this.player2 = player2;
       this.player3 = player3;
   }

    public int getNumOfPlayers()
    {
        return numOfPlayers;
    }

    public int getPlayer1()
    {
        return player1;
    }

    public int getPlayer2()
    {
        return player2;
    }

    public int getPlayer3()
    {
        return player3;
    }
}
}
