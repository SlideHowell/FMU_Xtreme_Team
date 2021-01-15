// Problem 7: Word Scramble

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = Integer.parseInt(scanner.nextLine());
        String[] testCases = new String[testCaseCount];
        for (int testCase = 0; testCase < testCaseCount; ++testCase)
            testCases[testCase] = scanner.nextLine();
        
        for (String testCase : testCases)
            System.out.println(scramble(testCase));
    }

    private static String scramble(String str) {
        char[] chars = str.toCharArray();
        int cursor = 1;

        while (cursor < str.length()) {
            if (chars[cursor - 1] == 'A' && chars[cursor] != 'A') {
                char temp = chars[cursor];
                chars[cursor] = chars[cursor - 1];
                chars[cursor - 1] = temp;
                
                cursor += 2;
            } else {
                cursor += 1;
            }
        }

        return new String(chars);
    }
}
