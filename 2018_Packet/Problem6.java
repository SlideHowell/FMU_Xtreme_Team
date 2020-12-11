// This is the start to a solution of Problem 6, Equatorial Real Estate

import java.util.Scanner;

public class Problem6 {
    static class Point {
        public final float x;
        public final float y;

        public Point(final float x, final float y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Triangle {
        public final Point a;
        public final Point b;
        public final Point c;

        public Triangle(final Point a, final Point b, final Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Triangle[][] splitAlongEquator() {
            return null;
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        final int parcelCount = Integer.parseInt(scanner.nextLine());
        for (int parcelindex = 0; parcelindex < parcelCount; ++parcelindex) {
            Triangle parcel = takeInput(scanner);
        }
    }

    private static Triangle takeInput(Scanner scanner) {
        final String[] pointStrings = scanner.nextLine().split(" ");
        final Point[] points = new Point[3];
     
        for (int i = 0; i < 3; ++i) {
            String[] coordinateStrings = pointStrings[i]
                // get rid of parentheses
                .substring(1, pointStrings[i].length() - 2)
                .split(", ");
            
            points[i] = new Point(Integer.parseInt(coordinateStrings[0]), Integer.parseInt(coordinateStrings[1]));
        }

        return new Triangle(points[0], points[1], points[2]);
    }
}