// Problem 7: Handshake Count

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        int[] groups = takeInput(new Scanner(System.in));

        int handshakeCount = 0;
        for (int i = 0; i < groups.length; ++i)
            for (int j = i + 1; j < groups.length; ++j)
                handshakeCount = (handshakeCount + groups[i] * groups[j]) % 1000;

        System.out.println(handshakeCount);
    }

    private static int[] takeInput(final Scanner scanner) {
        final int groupCount = Integer.parseInt(scanner.nextLine());
        int[] groups = new int[groupCount];

        for (int i = 0; i < groupCount; ++i) {
            groups[i] = Integer.parseInt(scanner.nextLine());
        }

        return groups;
    }
}
