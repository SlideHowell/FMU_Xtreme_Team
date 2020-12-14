// Problem 5: Triangle Island

import java.util.Scanner;

public class Problem5 {
    private static class Island {
        private final int a;
        private final int b;
        private final int c;

        public Island(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Island[] islands = takeInput(new Scanner(System.in));

        for (int i = 0; i < islands.length; ++i) {
            Island island = islands[i];
            double hypotenuse = Math.sqrt(Math.pow(island.a, 2D) + Math.pow(island.b, 2D));

            double westDistance = island.a + island.c;
            double eastDistance = island.b - island.c + hypotenuse;

            System.out.println((i + 1) + " " + (westDistance < eastDistance ? "go west" : "go east"));
        }
    }

    private static Island[] takeInput(Scanner scanner) {
        int islandCount = Integer.parseInt(scanner.nextLine());
        Island[] islands = new Island[islandCount];

        for (int i = 0; i < islandCount; ++i) {
            String[] islandStrings = scanner.nextLine().split(" ");
            
            islands[i] = new Island(
                Integer.parseInt(islandStrings[0]),
                Integer.parseInt(islandStrings[1]),
                Integer.parseInt(islandStrings[2])
            );
        }

        return islands;
    }
}
