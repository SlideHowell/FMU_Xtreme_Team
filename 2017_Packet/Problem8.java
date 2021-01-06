// Problem 8: Overlap Length

import java.util.Scanner;

public class Problem8 {
    private static class OverlapCase {
        public final String left;
        public final String right;

        public OverlapCase(final String left, final String right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        for (OverlapCase overlapCase : takeInput(new Scanner(System.in))) {
            int overlapLength = 0;

            for (int startIdx = Math.max(0, overlapCase.left.length() - overlapCase.right.length());
                startIdx < overlapCase.left.length();
                ++startIdx
            ) {
                String leftSubstr = overlapCase.left.substring(startIdx);
                String rightSubstr = overlapCase.right.substring(0, leftSubstr.length());

                if (leftSubstr.equals(rightSubstr)) {
                    overlapLength = leftSubstr.length();
                    break;
                }
            }

            System.out.printf("%s and %s have an overlap length of %d\n",
                overlapCase.left,
                overlapCase.right,
                overlapLength
            );
        }
    }

    private static OverlapCase[] takeInput(final Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        OverlapCase[] overlapCases = new OverlapCase[count];

        for (int i = 0; i < count; ++i)
            overlapCases[i] = new OverlapCase(scanner.nextLine().toUpperCase(), scanner.nextLine().toUpperCase());

        return overlapCases;
    }
}
