import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class Problem7
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int LINE = Integer.parseInt(input.nextLine());

        HashMap<String, String> table = new HashMap<>();
        table.put("me", "Kanye");
        table.put("you", "Kanye");
        table.put("she", "Kanye");
        table.put("her", "Kanye");
        table.put("he", "Kanye");
        table.put("him", "Kanye");
        table.put("my", "Kanye's");
        table.put("mine", "Kanye's");
        table.put("your", "Kanye's");
        table.put("yours", "Kanye's");
        table.put("hers", "Kanye's");
        table.put("his", "Kanye's");

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < LINE; i++)
        {
            String[] line = input.nextLine().split(" ");
            for (int j = 0; j < line.length; j++)
            {
                String phrase = line[j];
                String word = "";
                for (char letter : phrase.toCharArray())
                {
                    if (Character.isLetter(letter))
                        word += letter;
                }
                if (table.containsKey(word.toLowerCase()))
                {
                    line[j] = line[j].replace(word, table.get(word.toLowerCase()));
                }
                result.add(line[j]);
            }
            result.add("\n");
        }
        for (String word : result)
        {
            if (word.equals("\n"))
                System.out.print(word);
            else
                System.out.print(word + " ");
        }
    }
}
